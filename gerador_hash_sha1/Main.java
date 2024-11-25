import java.io.*;
import java.util.logging.*;
import javax.xml.bind.DatatypeConverter;
 
/**
 * Hashing with SHA1
 *
 * @param input String to hash
 * @return String hashed
 */
public String sha1(String input) {
    String sha1 = null;
    try {
        MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
        msdDigest.update(input.getBytes("UTF-8"), 0, input.length());
        sha1 = DatatypeConverter.printHexBinary(msdDigest.digest());
    } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
        Logger.getLogger(Encriptacion.class.getName()).log(Level.SEVERE, null, e);
    }
    return sha1;
}