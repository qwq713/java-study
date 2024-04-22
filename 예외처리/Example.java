package 예외처리;

public class Example {
    public static void printLength(String data) {
        try {
            int len = data.length();
            System.out.println(len);
        } catch (NullPointerException ne) {
            System.out.println(ne.getMessage());
        } finally {
            System.out.println("finally");
        }
    }

    public static void main(String[] args) {

        // Example 01 - NullPointException
        System.out.println("start");
        printLength("ThisIsJava");
        printLength(null);
        System.out.println("end");

        // Example 02 - multi catch
        int value = 0;
        String[] array = {"100", "2oo"};
        for (int i = 0; i <= array.length; i++) {
            try {
                value = Integer.parseInt(array[i]);
            }
            // 하위 클래스 catch 블록을 먼저 작성. 만약에 Exception을 먼저 작성했다면 아래 catch는 쓸모 없음
            // catch(Exception e) { System.out.println(e.getMessage());}
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println(e.getMessage());
            }finally {
                System.out.println(value);
            }
        }

    }
}
