import java.math.BigInteger;

public class Project2 {

    // Returns number of bits in number in hex
    static String getNumBits(BigInteger number) {
        int num = number.bitLength();
        return Integer.toHexString(Integer.valueOf(num));

    }

    // turn BigInteger into hex
    static String getHexValue(BigInteger number) {
        return number.toString(16);
    }

    // returns private key in hex
    static BigInteger getPrivateKey(BigInteger e, BigInteger p, BigInteger q) {
        BigInteger one = new BigInteger("1");
        BigInteger p_minus_one = p.subtract(one);
        BigInteger q_minus_one = q.subtract(one);
        BigInteger z = p_minus_one.multiply(q_minus_one);

        BigInteger mult_inverse = e.modInverse(z);

        // should the below be an integer or double or long?
        return mult_inverse;
    }

    // why are the directions telling me to look at modInverse
    // encrypt message
    static BigInteger encrypt(BigInteger m, BigInteger e, BigInteger N) {
        BigInteger encrypted = m.modPow(e, N);
        return encrypted;
    }


    static BigInteger decrypt(BigInteger message, BigInteger d, BigInteger n) {
        BigInteger decrypted = message.modPow(d, n);
        return decrypted;
    }

    public static void main(String[] args) {
        // Set up
        BigInteger e = new BigInteger("65537");
        BigInteger p = new BigInteger("bdf78a7a486847dc2fc6cccf45161dad36641ce09a1907ff5c5c088d3f9011135d0b77a75faabc6ff9d42499f9949b61ca5e32b5458b5240e2aafb18d9486bddbb80014b1f8945947eaafe6964a3ea96f345b2f0a93e7db100ab21c7b38d2e0d19fddfe8b8fcf8f593aae667edc15e76d9af847886e2db47a4b53243950eed016439c5874b5de2aba1065faeefdf1d9756ac8bc453b379ae18a85f3e911205b841f8da08ab52963b34661150938c2de16bf910a497049352422873a75531ca59", 16);
        BigInteger q = new BigInteger("ff8b62ff55f9f7a5a279db0960921f1b9f04172996867293b3987b1ad49160a2539156bc2c56489a046ede63b34c91ac5fe897d7865c0b62c7eed50c71e62163a6f9795653c6c4e1ad69477739f92b39bb8b9c99d0c780b641abccb307f405f141668847c25fcf2305e62902e6e5325bace643097581bd14f36008c0c8b33e27d06615728dcaa293f18c6a350ab3b7f634a66a097ecedaac8421ca24f24123236f57b4f520739d949594bd6efb029609282c9e87622b0a16514789001df5f545", 16);
        BigInteger N = p.multiply(q);

        // Question 1
        System.out.println("N has " + getNumBits(N) + " bits.");

        // used sage Math for part 1 of question 2
        // Question 2 part 2
        System.out.println("p has " + getNumBits(p) + " bits.");
        System.out.println("q has " + getNumBits(q) + " bits.");

        // Question 3
        BigInteger privateKey = getPrivateKey(e, p, q);
        System.out.println("Bob's private key has a value of " + privateKey.toString(16));

        // Question 4
        BigInteger m = new BigInteger("3");
        BigInteger encrypted = encrypt(m, e, N);
        System.out.println("If Alice's message, m = 3, were encrypted it would be " + encrypted.toString(16));


        //BigInteger message = new BigInteger(encrypted, 16);
        // Question 5

        System.out.println("Alice's decrypted message would then be " + decrypt(encrypted, privateKey, N));



    }

}
