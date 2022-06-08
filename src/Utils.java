public class Utils {
    public static Directory root = new Directory();
    public static Directory pwd = root;

    public static void cd(String path) {
        String[] pathSeparated = path.split("/");

        // root dir
        if (path.equals("./")) {
            pwd = root;
        }
        // parent dir
        else if (path.equals("..") && pwd.parentDir != null) {
            pwd = pwd.parentDir;
        } else if (pathSeparated.length == 1 && pwd.subDir.containsKey(path)) {
            pwd = pwd.subDir.get(path);
        }

        // full path
        else if (pathSeparated.length > 1) {
            pwd = root;
            for (int index = 1; index < pathSeparated.length; index++) {
                if (nextPath(pathSeparated[index]) == null) {
                    System.out.println(">>> invalid path");
                    return;
                } else {
                    pwd = nextPath(pathSeparated[index]);
                }

            }
        } else {
            System.out.println(">>> invalid directory");
        }

        System.out.println(">>> current directory : " + pwd.name);

    }

    // make directory
    public static void makeDir(String name) {
        Directory createdDir = createDir(name);
        pwd.subDir.put(createdDir.name, createdDir);
        System.out.println();
        System.out.println();
        System.out.println(">>> " + name + " directory created");
    }

    // make file
    public static void touch(String name) {
        pwd.files.add(name);
        System.out.println();
        System.out.println();
        System.out.println(">>> " + name + " file created");

    }

    // create a directory instance
    public static Directory createDir(String name) {
        Directory newDir = new Directory();
        newDir.name = name;
        newDir.parentDir = pwd;
        newDir.fullPath = newDir.parentDir.fullPath + "/" + newDir.name;
        return newDir;
    }

    // prints pwd
    public static void showPwd() {
        System.out.println();
        System.out.println();
        System.out.println(">>> " + "Current Directory : " + pwd.name);
    }

    // prints subDirs
    public static void showSubDirs() {
        System.out.println();
        System.out.println();
        for (String key : pwd.subDir.keySet()) {
            System.out.println(">>> " + pwd.subDir.get(key).name);
        }
    }

    // print files
    public static void showFile() {
        System.out.println();
        System.out.println();
        for (String file : pwd.files) {
            System.out.println(">>> " + file);
        }
    }

    // print fullpath
    public static void showPath() {
        System.out.println();
        System.out.println();
        System.out.println(">>> " + pwd.fullPath);
    }

    // pathTravel
    static Directory nextPath(String dict) {
        return pwd.subDir.get(dict);
    }

    // screen flush
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
