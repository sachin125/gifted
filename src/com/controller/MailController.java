package com.controller;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import AlgoRSA.RSAEncryptionDecryption;

import com.dto.MailDTO;
import com.msg.MyMessage;
import com.service.MyService;
public class MailController{

	public <MailDTO> List getSentMail(String receiver) throws Exception {
		 return new MyService().getSentMail(receiver);
	}// end of method
	
	public MailDTO readSentMail(HttpServletRequest request,HttpServletResponse response,MailDTO mailDTO) throws Exception{
		RSAEncryptionDecryption rsaEncryptionDescription =new RSAEncryptionDecryption() ;
		
		HttpSession httpSession = request.getSession();
		String emailid = (String)httpSession.getAttribute("EMAILID");
		mailDTO.setSender(emailid);
		String root = request.getRealPath("/email_store/");				
		File file_store = new File(root, "file_store");
		if (!file_store.exists()) {
			file_store.mkdirs();
		}
		File signature_store = new File(root, "signature_store");
		File email_signature_store= new File(signature_store, "email_signature_store");
		File file_signature_store= new File(signature_store, "file_signature_store");
		if (!signature_store.exists()) {
			signature_store.mkdirs();
		}
		File key_store = new File(root, "key_store");
		if (!key_store.exists()) {
			key_store.mkdirs();
		}
		
		MyService myService = new MyService();
		mailDTO =  myService.readSentMail(mailDTO);
		
		File publickeyfile= new File(key_store,mailDTO.getPublickey());
		File emailfile = new File(root,mailDTO.getEmailname());
		File filefile = new File(file_store,mailDTO.getFilename());
		
		String decfilename = rsaEncryptionDescription.decrypData(emailfile,publickeyfile);
		File decfile = new File(root,decfilename);
		
		String filename = rsaEncryptionDescription.decrypData(filefile, publickeyfile);
		mailDTO.setDecfile(decfile);
		mailDTO.setFilename(filename);
		
		System.out.println("emailfile path : "+emailfile.getAbsolutePath());
		System.out.println("publicfile path : "+publickeyfile.getAbsolutePath());
		System.out.println("decfilename : "+decfilename);
		System.out.println("filefile : "+filefile);
		return mailDTO;
	}
	
	
	
	public MailDTO readMail(HttpServletRequest request,HttpServletResponse response,MailDTO mailDTO) throws Exception{
		RSAEncryptionDecryption rsaEncryptionDescription =new RSAEncryptionDecryption() ;
		
		
		String root = request.getRealPath("/email_store/");				
		File file_store = new File(root, "file_store");
		if (!file_store.exists()) {
			file_store.mkdirs();
		}
		File signature_store = new File(root, "signature_store");
		File email_signature_store= new File(signature_store, "email_signature_store");
		File file_signature_store= new File(signature_store, "file_signature_store");
		if (!signature_store.exists()) {
			signature_store.mkdirs();
		}
		File key_store = new File(root, "key_store");
		if (!key_store.exists()) {
			key_store.mkdirs();
		}
		
		MyService myService = new MyService();
		mailDTO =  myService.readMail(mailDTO);
		
		File publickeyfile= new File(key_store,mailDTO.getPublickey());
		File emailfile = new File(root,mailDTO.getEmailname());
		File filefile = new File(file_store,mailDTO.getFilename());
		
		String decfilename = rsaEncryptionDescription.decrypData(emailfile,publickeyfile);
		File decfile = new File(root,decfilename);
		
		String filename = rsaEncryptionDescription.decrypData(filefile, publickeyfile);
		mailDTO.setDecfile(decfile);
		mailDTO.setFilename(filename);
		
		System.out.println("emailfile path : "+emailfile.getAbsolutePath());
		System.out.println("publicfile path : "+publickeyfile.getAbsolutePath());
		System.out.println("decfilename : "+decfilename);
		System.out.println("filefile : "+filefile);
		return mailDTO;
	}
		
	// jb hm send krenge to hm sender, wo receiver
	public void sendMailDone(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		MyMessage myMessage = new MyMessage();
		MailDTO mailDTO = new MailDTO();
		RSAEncryptionDecryption rsaEncryptionDescription = null;
		FileOutputStream fos = null;
		DataOutputStream dos =null;
		HttpSession httpSession = request.getSession();
		String emailid = (String)httpSession.getAttribute("EMAILID");
		mailDTO.setSender(emailid);
		long time = System.currentTimeMillis();
		rsaEncryptionDescription = new RSAEncryptionDecryption();
		rsaEncryptionDescription.start();
		String root = request.getRealPath("/email_store/");
		File tempfile = new File(root);
		
		if (!tempfile.exists()) {
			tempfile.mkdirs();
		}
		File file_store = new File(root, "file_store");
		if (!file_store.exists()) {
			file_store.mkdirs();
		}
		File signature_store = new File(root, "signature_store");
		if (!signature_store.exists()) {
			signature_store.mkdirs();
		}
		File key_store = new File(root, "key_store");
		if (!key_store.exists()) {
			key_store.mkdirs();
		}

		String privatekey = rsaEncryptionDescription.generatePrivatekey(key_store.getAbsolutePath());
		String publickey = rsaEncryptionDescription.generatePublickey(key_store.getAbsolutePath());
		System.out.println("tempfile: "+tempfile);
		mailDTO.setPublickey(publickey);
		
		try {
			String contentType = request.getContentType();
			if (contentType.indexOf("multipart/form-data") != -1) {
				DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
				ServletFileUpload servletFileUpload = new ServletFileUpload(
						diskFileItemFactory);
				List list = servletFileUpload.parseRequest(request);
				Iterator<FileItem> iterator = list.iterator();
				
				String filename = "";
				String value = "";
				while (iterator.hasNext()) {
					FileItem fileItem = iterator.next();
					if (fileItem.isFormField()) {
						filename = fileItem.getFieldName();
						value = fileItem.getString();
						if (filename.equalsIgnoreCase("receiver")) {
							mailDTO.setReceiver(value);
						} else if (filename.equalsIgnoreCase("subject")) {
							mailDTO.setSubject(value);
						} else if (filename.equalsIgnoreCase("email")) {
							
							File email_signature_store =  new File(signature_store,"email_signature_store");
							if(!email_signature_store.exists()){
								email_signature_store.mkdirs();
							}
							File signaturefile = new File(email_signature_store,time+".txt");
							byte[] signature = rsaEncryptionDescription.sign(value.getBytes());
							fos=new FileOutputStream(signaturefile);
							dos = new DataOutputStream(fos);
							dos.write(signature);
							mailDTO.setEmail_signature(signaturefile.getName());

							
							File file = new File(tempfile,time+".txt");
							fos = new FileOutputStream(file);
							dos = new DataOutputStream(fos);
							dos.writeBytes(value);

							
							//key_store
							File file2 = new File(key_store,privatekey);
							System.out.println("file2.getAbsolutePath : "+file2.getAbsolutePath());							
						
							//encryption
							File encryptfile = rsaEncryptionDescription.encrypData(file,file2);						
							mailDTO.setEmailname(encryptfile.getName());
						}
					} else {
						String fileName = fileItem.getName();
						if (!fileName.isEmpty()) {
							
							byte[] valuebyte = fileItem.get();
							byte[] signature = rsaEncryptionDescription.sign(valuebyte);
							File file_signature_store =  new File(signature_store,"file_signature_store");
							if(!file_signature_store.exists()){
								file_signature_store.mkdirs();
							}
							File signaturefile = new File(file_signature_store,time+".txt");
							fos=new FileOutputStream(signaturefile);
							fos.write(signature);
							mailDTO.setFile_signature(signaturefile.getName());
							
							
							String ext = fileName.substring(fileName.lastIndexOf("."),fileName.length());
							File file = new File(file_store, time+ext);
							fileItem.write(file);
							
							//key store
							File privatekeyfile = new File(key_store,privatekey);
							System.out.println("file2.getAbsolutePath : "+privatekeyfile.getAbsolutePath());
							
							//encryption
							File encryptfile = rsaEncryptionDescription.encrypData(file,privatekeyfile);
							System.out.println(""+encryptfile);
							mailDTO.setFilename(encryptfile.getName());
						}

					}
				}
			}
//never disturb code
			mailDTO.setLtime(time);//for date and time
			// check with service and dao
			String ret = new MyService().sendMailDone(mailDTO);
			if (ret.equalsIgnoreCase("success")) {
				myMessage.setMailmsg("email sent successfully.");
				request.setAttribute("MMSG", myMessage);
				request.getRequestDispatcher("composemail.jsp").forward(request,
						response);
			} else if (ret.equalsIgnoreCase("error")) {
				myMessage.setMailmsg("email not sent.");
				request.setAttribute("MMSG", myMessage);
				request.getRequestDispatcher("composemail.jsp").forward(request,
						response);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				myMessage.setMailmsg("Server side error.");
				request.setAttribute("MMSG", myMessage);
				request.getRequestDispatcher("composemail.jsp").forward(
						request, response);
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
		}

	}

	@SuppressWarnings({ "hiding", "deprecation" })
	public <MailDTO> List getInBoxMail(String receiver) throws Exception {
		 return new MyService().getInboxMail(receiver);
	}// end of method
	
}//end of class