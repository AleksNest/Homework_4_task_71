// Task 71. Simplify Path


import java.util.Stack;

public class Task_71 {

    public static String simplifyPath(String path) {

        StringBuilder canonicalPath = new StringBuilder();
        Stack<String> pathItems = new Stack<>();
        String[] folders = path.split("/");                       // формируем массив строк без "/"

        for (int i = 0; i < folders.length; i++) {
            if (folders[i].equals(".") || folders[i].isEmpty()) {       // переход к след строке массива строк если есть "." или ""
                continue;
            } else if (folders[i].equals("..")) {                       // если есть в массиве строк "..", то удаление значения из стека
                if (!pathItems.isEmpty()) {
                    pathItems.pop();
                }
            } else {
                pathItems.push(folders[i]);                             // заполнение стека
            }
        }

        for (String s : pathItems) {                                    // построение образцового пути
            canonicalPath.append("/");
            canonicalPath.append(s);
        }

        return canonicalPath.length() > 0 ? canonicalPath.toString() : "/";
    }

    public static void main(String[] args) {
        String path = "/home/../foo/./dd";
        System.out.println(simplifyPath(path));
    }
}


