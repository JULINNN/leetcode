public class SimplifyPath_71 {

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home//foo/"));
    }

    public static String simplifyPath(String path) {
        String[] arr = path.split("/");
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if ("".equals(arr[i]) || "/".equals(arr[i]) || ".".equals(arr[i])) {
                continue;
            }

            if ("..".equals(arr[i])) {
                index = Math.max(index - 1, 0);
                continue;
            }

            arr[index++] = arr[i];

        }
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < index; i++) {
            stb.append("/").append(arr[i]);
        }
        return "".equals(stb.toString()) ? "/" : stb.toString();

    }
}
