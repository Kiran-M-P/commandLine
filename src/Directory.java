import java.util.ArrayList;
import java.util.HashMap;

public class Directory {
    String name;
    HashMap<String, Directory> subDir = new HashMap<String, Directory>();
    ArrayList<String> files = new ArrayList<String>();
    Directory parentDir;
    String fullPath;
}
