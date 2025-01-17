import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class IOImporvementDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path source = null;
		Path target = null;
		try {
		source = Paths.get("src/main/java/source.txt");
		source.toAbsolutePath();
		/*
		 * target = Paths.get("src/main/java/destination.txt");
		 * 
		 * Files.copy(source, target);
		 */
		
		Files.lines(source).forEach(System.out::println);
	
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(source.toAbsolutePath());
		}

	}

}
