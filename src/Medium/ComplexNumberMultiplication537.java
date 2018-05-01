package Medium;

/**
 * Created by kushal on 8/26/17.
 */
public class ComplexNumberMultiplication537 {
        class ComplexNumber{
            int number=0;
            int complex=0;
        }
        private ComplexNumber multiplyComplexNumber(ComplexNumber num1,ComplexNumber num2){
            ComplexNumber output=new ComplexNumber();
            output.number=num1.number*num2.number-num1.complex*num2.complex;
            output.complex=num1.complex*num2.number+num1.number*num2.complex;
            return output;
        }
        public String complexNumberMultiply(String a, String b) {
            ComplexNumber num1=new ComplexNumber();
            String nums1[]=a.substring(0,a.length()-1).split("[+]");
            num1.number=Integer.parseInt(nums1[0]);
            num1.complex=Integer.parseInt(nums1[1]);
            ComplexNumber num2=new ComplexNumber();
            String nums2[]=a.substring(0,b.length()-1).split("[+]");
            num2.number=Integer.parseInt(nums2[0]);
            num2.complex=Integer.parseInt(nums2[1]);
            ComplexNumber output=multiplyComplexNumber(num1,num2);
            return output.number+"+"+output.complex+"i";
        }
        public static void main(String sp[]){
            ComplexNumberMultiplication537 complexNumberMultiplication537=new ComplexNumberMultiplication537();
            complexNumberMultiplication537.complexNumberMultiply("1+-1i","0+0i");
        }
}
