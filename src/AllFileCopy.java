import java.io.*;

class AllFileCopy{
	public static void main(String args[]) throws Exception{
		System.out.print("Enter Source Path : ");
		String s=System.console().readLine();
		System.out.print("Enter Destination Path : ");
		String d=System.console().readLine();

		File file = new File(s);
		String ext = file.getName().substring(file.getName().lastIndexOf("."),file.getName().length());
		int sep = file.getName().lastIndexOf(".");
	    String filename = file.getName().substring(0, sep);
		System.out.println("ext : "+ext);
		System.out.println("filename : "+filename);
		
//		file.getName().lastIndexOf(".");
//		FileInputStream fis=new FileInputStream(s);
//		
//		FileOutputStream fos=new FileOutputStream(d);
//		int x=0;
//		byte myData[]=new byte[1024];
//		
//		while((x=fis.read(myData))>0){
//			fos.write(myData,0,x);
//			
//		}
//		fis.close();
//		fos.close();
		

	}
}