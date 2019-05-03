import java.io.*;

public class Web {

	String title;
	String html;

	public Web(String title,String style,String align) {
		this.title = title;
		html = "<html><body><h1"+" style="+style+" align="+align+">"+ title + "</h1>";
	}

	public void createUList(int header,String title, String[] bullets) {

		String list = "<h" + header + ">"+title+"<ul>";
		for (int i = 0; i < bullets.length; i++)
			list = list + "<li>" + bullets[i] + "</li>";
		list = list + "</ul></h" + header + ">";
		html = html + list;

	}
	
	public void addPicture(String dir) {
		
	}

	public void closeFile() throws IOException {
		File folder = new File(System.getProperty("user.home") + "/Desktop/KungWeb");
		File website = new File(folder, "Website.html");
		FileOutputStream stream = new FileOutputStream(website);
		html = html + "</body></html>";
		stream.write(html.getBytes());
		System.out.println(html);
	}

	public static void main(String[] args) throws IOException {
		Web Kung = new Web("Kunger's Cool Website","color:blue","center");
		String[] firstList = { "A", "B", "C","This totally works" };
		String[] secondList = {"Ab","Bb","Cb"};
		Kung.createUList(2,"First", firstList);
		Kung.createUList(3,"Second", secondList);
		Kung.closeFile();
	}

}
