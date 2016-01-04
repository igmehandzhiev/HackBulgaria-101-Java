package p37_reduce_file_path;

public class P37_reduce_file_path {
	public static String reduce_file_path(String path) {
		String[] arrPath = path.split("/+");

		StringBuilder newPath = new StringBuilder();
		for (int i = 0; i < arrPath.length; i++) {
			if (arrPath[i].equals(".")) {
				continue;
			} else if (arrPath[i].equals("..")) {
				int prevFolderStart = newPath.indexOf(arrPath[i - 1]);
				int prevFolderEnd = newPath.lastIndexOf("/") + 1;
				newPath.delete(prevFolderStart, prevFolderEnd);
			} else {
				newPath.append(arrPath[i]);
				newPath.append("/");
			}
		}
		//System.out.println(newPath.length());
		
		if(newPath.length() == 0) {
			return "/";
		}
		
		newPath.setLength(newPath.length() - 1);
		return newPath.toString();
	}

	public static void main(String[] args) {
		System.out.println(reduce_file_path("/srv/www/htdocs/wtf"));
	}
}
