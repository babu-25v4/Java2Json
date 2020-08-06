import static java.lang.System.currentTimeMillis;

public class TestJava {

	public static void main(String[] args) {

/*		String acc= "admin@qa91";
//		String acc= "ipush";
		System.out.println("Acc Name: "+ acc.substring(acc.indexOf("@")+1));
		System.out.println("user.home: "+System.getProperty("user.home"));*/

		/*String str = "AaAABBbCcCcDdee";
		int count = 1;
		String first, next;
		
		for (int i = 0; i < str.length(); i++) {

			first = ""+str.charAt(i);
			if(i != str.length()){
				if(i==str.length()-1){
					next = ""+str.charAt(i);
				}else{
					next = ""+str.charAt(i+1);
				}
			}else{
				next = ""+str.charAt(i);
			}

			if(first.equalsIgnoreCase(next)){
//				System.out.println("equal: "+first+", "+next);
				count+=1;
			}else{
				System.out.println("Letter: "+first+" appears: "+count+" times");
				if(i==str.length()-1){
					System.out.println("Not equal: "+first+", "+next);
				}
				count = 1;
			}
			first = ""+str.charAt(i+1);
		}*/

		System.out.println("---"+Long.toString(currentTimeMillis()));
		System.out.println("---"+Long.toString(currentTimeMillis()));
	}

}
