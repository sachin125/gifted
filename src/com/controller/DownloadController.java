package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AlgoRSA.RSAEncryptionDecryption;

import com.dto.MailDTO;
import com.service.MyService;

public class DownloadController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public DownloadController() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ServletOutputStream outStream = null;
		FileInputStream fileInputStream = null;
		MyService myService = null;
		try {
			String filename = (String)request.getParameter("filesession");
			System.out.println("downloadcontroller : filename :"+filename);
			
			String root = request.getRealPath("/email_store/");
			File file_store = new File(root, "file_store");
			if (!file_store.exists()) {
				file_store.mkdirs();
			}
			
			File filepath = null;
			outStream = response.getOutputStream();

			if (filename != null) {
				filepath = new File(file_store, filename);
			}
			System.out.println("downloadcontroller : filepath :"+filepath.getAbsolutePath());

			if (filename != null && filepath.exists()) {
				response.setContentType("APPLICATION/OCTET-STREAM");
				response.setContentLength((int) filepath.length());
				response.setHeader("Content-Disposition",
						"attachment; filename=\"" + filename + "\"");
				fileInputStream = new FileInputStream(filepath);
				int i;
				byte buffer[] = new byte[1024 * 100];
				while ((i = fileInputStream.read(buffer)) != -1) {
					outStream.write(buffer, 0, i);
				}
			} else {
				String ret = "file not found.";
				outStream.write(ret.getBytes());
			}

		} finally {
			if (fileInputStream != null) {
				fileInputStream.close();
			}
			if (outStream != null) {
				outStream.close();
			}
		}

	}
}
