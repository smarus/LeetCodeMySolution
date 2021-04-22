package Linked_list;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static javax.crypto.Cipher.DECRYPT_MODE;
import static javax.crypto.Cipher.ENCRYPT_MODE;

public class Iso {

    private static byte[] iso9797Alg3(String input, byte[] keyA, byte[] rightKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = iso9797Alg3DesCipher(keyA, ENCRYPT_MODE);
        Cipher cipherPrim = iso9797Alg3DesCipher(rightKey, DECRYPT_MODE);

        // ISO 9797 initial transformation no.1, pt1: ISO 7816-4 padding
        byte[] padded = AuxUtils.h2b(input);
        // ISO 9797 initial transformation no.1, pt2: DES/CBC Encryption of all the blocks with K
        byte[] cbcEncrypted = cipher.doFinal(padded, 0, padded.length);
        System.out.println("STEP1 DPAS + CBC encrypted: " + AuxUtils.b2h(cbcEncrypted));

        //debug encrypt wit ecb
        ;

        // ISO 9797 output transformation no.3, pt1: DES Decryption of the last block with K'
        byte[] afterOutputTransformsFirstPhase = cipherPrim.doFinal(cbcEncrypted, cbcEncrypted.length - 8, 8);
        System.out.println("STEP2 DPAS: afterOutPut " + AuxUtils.b2h(afterOutputTransformsFirstPhase));
        // ISO 9797 output transformation no.3, pt2: DES Encryption of the last block with K
        byte[] ret = cipher.doFinal(afterOutputTransformsFirstPhase, 0, 8);
        System.out.println("STEP3 DPAS: " + AuxUtils.b2h(ret));
        return ret;
    }

    private static Cipher iso9797Alg3DesCipher(byte[] bytes, int encryptMode) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKey key = new SecretKeySpec(bytes, "DES");
        Cipher cipher = Cipher.getInstance("DES/CBC/NoPadding");
        cipher.init(encryptMode, key, new IvParameterSpec(new byte[8]));
        return cipher;
    }

    private static String iso9797Alg3(String joinedKeys, String input) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException {
        byte[] leftKey = AuxUtils.h2b(joinedKeys.substring(0, 16));
        byte[] rightKey = AuxUtils.h2b(joinedKeys.substring(16));

        return AuxUtils.b2h(iso9797Alg3(input, leftKey, rightKey));
    }

    private static byte[] iso7816d4Pad(byte[] input) {
        int remainder = (((-(input.length + 1)) % 8) + 8) % 8;
        return AuxUtils.bconcat(input, (byte) 0x80, AuxUtils.bdup(remainder, (byte) 0x00));
    }


    public static int b2s(byte... b) {
        return ((0xFF & b[0]) << 8) | ((0xFF & b[1]));

    }

    public static int b2i(byte... b) {
        return ((0xFF & b[0]) << 24) | ((0xFF & b[1]) << 16) | ((0xFF & b[2]) << 8) | ((0xFF & b[3]));
    }

    public static List<String> convertByteArrayToArrayList(byte[] replenishBundleBytes) throws IOException {
        List<String> replenishmentBundle = new ArrayList<>();
        ByteArrayInputStream bais = new ByteArrayInputStream(replenishBundleBytes);
        DataInputStream in = new DataInputStream(bais);
        while (in.available() > 0) {
            String element = in.readUTF();
            replenishmentBundle.add(element);
        }
        return replenishmentBundle;
    }

    public static byte[] convertArrayListToByteArray(List<String> replenishmentBundles) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(baos);
        for (String element : replenishmentBundles) {
            try {
                out.writeUTF(element);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        byte[] bytes = baos.toByteArray();
        return bytes;
    }


    public static void main(String[] args) throws BadPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, IOException {
        String otpKey = "3048AAF014DBE1B812427447BE870A8D";
        String otpKey2 = "3049aaf114dae1b913437447be860a8d";
        String otpKey4 = "3049AAF114DAE1B913437447BE860A8D";
        String rawData = "00000000800008400102030400012012C0000000B0008000";
        String rawData2 = "00000000800008400102030400012012C0000000B0008000";
        String result2 = "bb9415fb55155ec1";
        String jsss = "47B5F87ED8C86C08271C091AEB2B0ED7492D31701EF55B4E45BA5E94F3BF9A713535F865517B54A715E4E93C814DFAAB0D9F58207597F30DAD6E2EC195C0744F4557281C54CB0C4417C9A987A7813122083A6A5A4FCAD2BA290747D6BAA4371F1260D3183525B719E219FA27227A20E3310B90CAD664A547563979216A7FE2C2EC69D5FD178EEA65C1837DD8BAA9C1C109310B48264C5B27409F8315A54D33DBA9219B644F2326CC8C054BE3C10FD5277B97D0EFE2AB120B0BC6D08411EE7D319CEA0AC0F1CCE963662CAE194E5A0D2B754760B1D315A6FFBE4E5AE69D03A9ADFB64C2CE7D2E951E030770A00C7EBD90175338DD20201749D0550000FEB16FD6903E9218E3C162E23BDEC0DE41306E01F9DEE053045E19F0E3D913DC304AA94D91C656EA0DB784DAEE6831AA5F4E376A0992BAEFBC606F3454D6E91670B1C49F7B0CFCFCB2C6A7F64D056BCFBEC9C24045E7703725426D8C030A7492AE75BAC1641F657A5DBDB5D737664BDDA4AD18FD2E0FFE31CE4BE42AB86E2FEF435D87857DC5A772B7364CAF1FD49F4A0BFC782AD692C45CDDFD96960ABC0B96AF5A4FA6DF66CF92799E1303B180B4AE576D725703A3FB3A3E337D08B4714147EB885BDD346D9A429E804459115185E10F10C501471D6965B263E443C813CDF984E110EE4B237F29D44691E6E0C844F04506CBDC6C27F47BC2A4C0281213F89D7995FB028FBAFFBA657A8B024DDE66A450EF9DC23EA9F0ABE5E5047F609B8A2AD106E0811B0AE3C68A0293EBE7D68FF53BF0AFF0E785390A9160B46911BDB818FD6B2596BA6B02F8AE8808F01F247E2A6627C702E630850CE582D8E26BDAF05134C2165A6DDA754DEBA1C1D2F44DF3038634AFDDD963B85708FE4E4E9789E799B9971A20F6A60C90D285F33A96F334F8345A61FE4D864D389A89B929F8BE0B86A77606E8FE0D7CB0348909729F66541ED10132FCBE89E0F9CC5FE6DFE04624E84E5890B030E1A6B7D07E51EDECE873FEF39EE9437F1684768CEB05791E938A44D5443465940627A776B7543CB4E46C92A474AE2709E826370076393605FCBDD0D69946094511389EEDA920D8C1C97B3EC5C8D1D60AB36DC85F792963E0FA4B4DFCA437CF41FB5BFC73772E657690B2BF82FBB0902EB0E121E5A98E987CEE5F5C49F0FA7D0C413E9DB71BFE93865D3B2A26CF8C061C1CA3567859C68B26DB0443C64417DF4BF79478B4E883C1D5D2ED277689DCDF9B39C2904A615EA988D1F118E9CFA0B776A093FC3028E9DA5959D0EA45B90CA43C9C1D04CCE40F8CF1C75BC0614FD26D40D67333105B2DF900FA00AD06827D65156F2FB503D96BD692A4C6571765724F41B79DB6FB169E1A3074CA01B3F15BEF64F335973CD617B6914614D6BA978B1D891F15D889357CB38D524C9278FA875CEF4243B7348852EF5F3CF7697491E46CCECDD66B4747C146D7907E195EEF9DB10E4DB1E33825E3EDC405140F81613E56A500C06D98634D5744BC1BB6CCB6D74C906A1FE7A79A9CAEFDC77BCC12E7DF89686F13D6D58EC6F8EDB99C44EDDBFB0D1BEDCFC34E65370944E7B49E4533B078165615F7642D91122B104CE47BEE08848F3715CAF700056E38D602EDDE75B9A396103284899D490CAAF3E9B5AECB0A46FA9717EFAA93BD5145CB7F9CAF895115CA1B31A713D098A600037F48F3FE8A6CE972D4DE6E1F21DA658C2FAA1DAA167772FD6945886375BDA106C2A7F687E3244DD78D1F6A49A00866419CEC2746B570C0F7D5E8CD3F22AC3097E8441739A77FDC93BB44484DDEC2E85FC335E1B1A609280C8B491CFE809045136E198EA1C680887953EABEF86789FB146831D43EF4884F12B42D816B35555DB4E5D6C943061B2583B578E22A1FC394C8DDB4A2622EA514ED2FEC8BB5426ECF9228B3EEC8671A86ED88C8901B2E85CBDF4345CF4F614ACB146185A52A1A9EA3797384188A3FE2B5CF6B282C85C0D86A9DD4114F2B47373D24F5F3F4076CE0C5020514340679761112F6C0F6ECF9076D87F954DEEEC1CDCAA3DFD1872196E8BC519C54CBCB6715F25E140EF9F64E0EEACC6EA1AD27AA366F3090B1C66CE08337A9609FDF31AC5865C77FA98E86C574B77FAD258267E21CF94461AE18806DC9070603029A49ABC72CF5C88AB8A5468D1107C0EAE52ABE63ED7AEC63AB7B3183D4ABED99188B9B4D4E26FF8F2BA26880DE40162591352A86F7A04B0BAAC7E11A64744350EF17F355CFECB33FC2FC9D13E43D67C0FE4794BCE51E638110A6B18DD83A7D220D6EB434F464C23EFF1159EB14EBB3585E01A5FE6DA52292E176AFEC6B712C517EB295936623D14D38C43A7694D3E5DAF0936EA77856E0C86C9544C5BB5F96E46319129D24DAEEF9C51D68D2835D9D8C65D90B0B1EE122FC8910C05BA1123135FE4855129B94B414FC7F2C26759B0C905D5F5080DAE3AD13B97F66325AA5E821517BEE37DD4F4CB44EDD9C96C617C59BDDCBB21100C12E55E3D95DBC8ACB8FCF92EF92A89464E66352C6419C547755DE74EC579D8ED3B5032BDBA18B3DFE1159E0A1DA071D5241A3CA28334A98C321CA2B672935350C72BEB23DEA12EE8FE593A66E3D91A72F087070F005A2BDE5BD91474CC7CB4232F670DB6F15A502E695385EA402B7E2D1278A68AFEE17CFF76C7998226E71F541A10031EA4D383CB387551AE46DFEE861119149237C0C1C96C37148383A13DF2541D566870AD6D734A7C8DC33CDEEC6A0D110FB4895223B3CBDDA92C0AC1B7B267BA065DA502CE655C9252228A9D92059AF8A359220A96E4A4199154E007B8DA172F2BB9C095E78FE4A75634807A42EA78A3B04B13242909B7E81EB577F4138CD9AD2EB55A5B65BBBE696E063BCBDBABB4CE0ADE3E454C155C4490E5C4E94846E5B86D8A93544B1CE3AC8F94A7A01A80560BD4A8EE017327831A801491D0D40C692DB9FA0BCA3D1DD27C6B23A92BA1474CD0F21EE99B567A77B468EC72BC40EF5EC2D621CAEE984C8B7DF70C93B5773307CAAB4FB612309152C3C615352DDA37DB865BA7DCA3D7B2A5B0BD25CD2A6AE56AC3EE004C2CA8B1765CB1940BCFFF98CB28F21C4E61FF72294BBE3C738F8E9C01C4DF0B9F4895F2C2FDAF87D3964E0C61CC1DA1457E68F8415B8BD70749FE6F5633CAA38EA38E567A4C43B624AB149F35B8D231C4721ED675DCFB41D163DD7D09EFFCAD9007203B0AEF11065EE66C703617AB275F2644230EEB3DB6A79E22186B2BF2A03896E22720ED500EDC063F75C401DEC8914088C54A8BD79483257745F6A6E9575C9812E6F0E4462A5C5B658DC2786D121320F62CD973257EA3C8257C495D2363CAD2BEC075C52204D5858362D71F9338C4B65A92537D4BE25E2F4C11A7B33FBF2C036E829327D354BA4349D3B3AD5280B7F88346F19C27DA7ACB73D633AC408223F44B8911EBA3D652BD10946445647C9E7FEA8326A7FBDCA42CAB76D8A53415A3C456F755DC67102CF33214760E273690B9A01C21A1729E12AED48D02CBAB61979A0498D9CB2D30AE857557564A01A2301F3C7A2A4942C617D5EC49A57DC0CB1371208075676AD1D8EDF37EE28707DA55CE4D8FEEC287157515974E3E5351D100D5EFB41AB1CF5D9B798F19E5C398AF2FC3E35FEAEFB156C338DDBC3598E501A96ECA238E917B41F1094BC373367BB07DAF043C8D77CF97BFF01930702C137D9D94EA85931CFB05851B6C6A5812FDE8660178BF69BA4866FD09887B3CD914DBE7C2BE6B55C3A16AD39D7B6C98DD775FB0F58C04F4EBB8A38ED45AF575C30FFBD7275ED4CE2F74EC2102A33D74AEA536365FA8BC4720283E8E32620E48AEC0A7177CEC877DFC086BD6F23C93990A5E7FC54FAD10F15F46B79865B857231D04D7A75D0EB88582BE0DA704F1CD997E83752FB74B9E5CC354127ED591507F103C1A8F7AEAA7C367C4D29962C9BFE48B3BA7813BEA485101A8E41DD2D2C5292E494E502E5E8B567E8F841FA6E3D8027BF8D1F7F4267916E0FB70F3C799146E0D43748C8A8699FCCC28B4E45E4D567269277E55F596B7B71137AF6D7557552B211C4CC1A64D96E36AC94DC21B55E5BE91DE4A4E05492397BD2555E6991D55D626C6AC017C09AB507FB5439B83E0C9BFD5F539F760C6E6F5928A0B0CDC699B297094FC2B5A40E7589A9D2A8D18EC510A3C5BF977BCB55DA193B69E6829E40DC5602BCD60F369AB32B291DE1BE3AFD5BCF691E7A34AF564B6513F69BDB13471A6820F374C6203F7F8108121946243D2878324052EB491E0805C06ABFFB609C3C622D88234632A4B343F8CBA8F411F4C582DB1CA129A9EC9C2CFC48EE3AA236B69C6DF52BE316A325780DB81342021AD5C77D47C22D3F65B920BDA1E2B4AB7997DA4F108A82B57223EEA66093BB48A285D13D233E7E1E0D83FA2F0FDC2D592773306B09E25C84523F846E49315B87F128C8B0C59ECF58269FB9ECEC34C3D93F7095A8107EA6694CD84F1EE3485CFBBCF13B86C62A80CBC61BB842865F6E4232D5DC35399C44AB7FA3971937ABBD1A3ED9888002F9460C02DCCCA0515123FDF15AAE29C408734022B4B9C053D478FA1D150A71350771E84ADED56238E5F10DB9944F74A9E93E4C2D5457820F97FF5A8FF1C76593D8BC2F3A9BEFAB3984E237E3E722640C0F63BD74679A46AC11A2884CB388BDE2A52343EC06EA623B5B3B2F9318D03CA34009C68401D064B19D7F76E1C7EEC3E70D6F28FF5523EF1FACE3D55F3E30467F9AC2D7CEAF18C7B5003F47B1703D8931453936A757BF8C1245A0725CD72B3A8F9D853305CC56D0CBEE6D63F0BDA93E209C3065B7D01FDA0B753F27E802DD3B070FA50EF924F3C1AF0E0F8803689E83F83941E1700FBA0B624C24507780D77353CD4AA35460E643CB27F0576F32EEAB2CA2E9B921F9A66CEA4AF5C2410DC8105A55B38696E53F49BB24325D42451DB2972383E7A33D90649AB1B2B8BF8CC9E5D0017670230DD9A88D3D06D7924DF498ECE44409BD6576E13B9549DB822F706B75F0CC296B33B5AC758C8E436549CBD6F912C18559EACD56C3401EEC137E2A5FE6D3BA29E02763C50E3197384AA4E4CA828973931110FA4445BC283011B1FA2009CF51C072CAF480EF1EFAAD9C373AE2062F668E0A30AEBF8A13CD2067C623D9A677B18929C834CD8CAFB9169FB8C591ABF2174C117375F7F55F23E679B6D96499D34C787A49E64B6BA7E253890F208D68B934C929471D9F9DBD65D1AE042E13D2D9AEF8D2D68F41EB530D25256A2E65F954B43187D0E594610043A990DF06E1BBD5D04B2E77425E125CD0EB78754BD02392067F5D4739C7E59CF437E4DC3896CA2303888781D754F9E5E251F059B0F910ACAA0528C12B3C4F7AE33E367057DDA6214A41F73C02C47E6B5D900DA5F75536D97062901E7ADD88C5C16C69FAB0A3AC75DD13831FBFCF4212DEB7D4A66E279C76B3EE9BA83A292BA516AD395209720D5F75242B65193F698CF50375B48A165ADA156B89261A86BB17EF582885B8C9A7CB4F76B1BE3784BC2EE642B0C8BE226FAC1D61026D64A6D89939F6BB77F4FD9C9BA74B0D7E74A5A2F4215CE8C0DE2313A1B31C4D1C1A7629B9583D2A152C98A697142201115D26154CE312D0D8CB2523CBADB769B8E796629AADA464480B90AAFDD9CF122675CA5A329483C4E6E31F1C5CC0628BA15DDEFD6D955CC70DBBEACE2CECD01FFED5BA716846C56B3513A07A8EB7B589666C5C5A641938B075E0E058DCFB099A24A72B1F7836F22C56609D8589E2BE7136F87E71DB7421590C799C1DBD1476BA0CC8D9FA6AB98C8D3F03E7D3898EBF62028E23E487B5D1038FF24191CB2ADB1D747DC5B2D1AEC621DD95344B3622AC9464EC4F7C1F9E5E9A8474CCF36FC5E2572FCA0155778A676CC8E40B34A724798EA4FAA07DA64325C9994D64B41686E143573A608B5207C48B081819F3D56D01DFC271605C7DAB151A5A37B2FF81D4B7AAA339D96D0A05E0B107323A7F45216A7275980C08B4458E166D830D1C03EAA481D4470B4FBC74B010E3505D845B399D90322A559F4E115CBF6FED2BAE77A9E4EB85C36E2F6653558964E1614694C080821065B80366CBB62250CF61148D04FC7810993A1F80F03D90E6CD86AB9A304E61E62CB33357E1E72F986FCD59018518C2551D08335F7CFE0392272DC0342C6A96BFF9F380C6F45C000C21D574E89D2DED5FA094976EDCB543F03EDECA2761DF80B95BFCF44F974F97E303A937D8DFF7388BEB474A6A8130304266BFBDD8AC1CBC59E0234586B3B953145BD714B99507F63A8EAA2946EEA06429FCA5AE352422325EEEABDFA51FE5DEEAB521BEB66FA7663A3B7947245937E2C592FAE8A2182AE7933D11FAE5AD604D621961951AD308DFD883732F283BD92897B3FDD8AE4E258C0B5E669B4C45318CF6FE36D9A39B361DA384749B56B9BBBB949ED4029F8545F836219814E07EC812C86FA8771E44B7DF079EFC24445E62B9CE75F6A054BC47A181AA1D13B93EEDA0010C7DADDF711CE4FF14E4698423A491AD223158EC196310AF8F503945A9B9ED409C0E31467B21A1F5C6FF1D26C1C521C056788138F563488484C86274A5C42155D75298DC45DB71150095EF74E19EF527444F4F7CAAEBF5B06140549DDAFA65076802A4780B3F28AF21EAC9AF65F80054E86E5D2D9591BB74C4E469D7B57845443675847D81267B57032FDE045AB03DAB6759CFDB215E0278358423786DCDB130351F127F443946141139DC74C5EB803AB499D3EE0FCF29FAC0DEE52F82D247390CA765D4C5A14070C1CB5EFE98DEBAD1431EB83F96A4EB2C91DBA5E005D3F222A711ED9D8E6B9664319A10170A3BCB3A98F6C68523260F254F2EBEBE40B5E2CCF1095A370B94F86F3BC9DDB1C0740DE4505E55ADA52D1A3B3FCA057FFAB897057671A75600D7DA02D504C89FEF90E3E35127FDA1CA417161ED98E368E9F3E5F3BC8EEC79E2F2E8DE8A3CC6FADE61A6447B73D429E1FB8BC59A5E7C547FAD9D71041E3670CC62D468E501C5842F2C6E81F3FB0809DCF2908E968B5A138567397E5E4D6377E9C6D107C5D93EF60E062890AB876B4D004DD6C6335E522AA02A177C613A05F69B82740E2432D855423055E02C4C6C84F02DB7A03EC10E679A7ADB8A945F5F536EEDEF107CB627CC104DA3676AA168A9DD88A8C24BB973A1B870C54716949EF1B1066705D228509B65B145225F9FC307412A7F6068BBABBD34A64DDDFFEF938225B3AAED7B660A9749E549F4848B25B03F1C5DFF4C346506DEC9A99911CB99F3F0D23899A95D1042578E2BFB160A3C190821C53607671FAABC2EE4D5828FE2BF650A5FE68836A284A4528D5E6C9F83A2FAD373E54B53F4E440578E08427A1D9DA291AD402117476A044841B56F26808D4A5011E328BD2862822A3430AA1B14DB9053143FB8972201A699BFDEC29F5F821688EC6A8A5F45046670BA329BEABD00150B937A6B9DFABA340B9BBFE82EBDB866AED48D4CA105975063CC3E971DD87A8650D968C699CFDEB85CA59A5FAF480765D7DE014081B87D9E814A9C26A91ABA1EEA761EDEA979C949A4E82849C4E78074B0FBFF50814B8F003D36DDDBD4722C0F8A20D584B8E50E07C3DCC878BD4C876DDB470B3B3F7BBEC065B2A15EC7E2878E53A3C63838E0FA989FE44E69768CB0552F5AA8108EC8B135AD0C17667AB92DA2B64623AD83F60D015486BE595B90DB01B15437D53308D9D668BB93F251E62020AB99E040D5DCCE00233F2DBA995B7C3869AC99250079AEFF146648C0201D47102A1A7BC9A5155535328A1B2F8D2862487D97E637F4368129ABA05797A48C7B1EA60851A5E23D2AABBCB0EE490326E732CC7C06434EFFDA15AD48436B074F354FE4255B5D19EB21321DE70EFB1A4B5C16608A6326E18A5C4EEC7F9EE7FB7393E31FBC62C2876B95DEF6FFC0DAF4E9F92DABA55FBFD614F3921191A29FC37394D68D5DBD2B114FDB68CDFA1B5110961052D2A8574924AAD2074B0AE45F720CD8389820C486BBCC93DF42EE636AC25CE5F33FAA55BC18497A99A3C1CCB1F4346A19A92758DC6DDAE73D9956DEB863660CD947357BBC3C6B497ED69EB1B9120082FAE9775B22D83189CA87DE045658948DFC8DABCBBCC15240DD6C10133605C1B9477109DEB3576B6C83BA2DA47220AA2002ECD155D16233E8D410B46247A410DA7F141C5C059D07D155E0D6A67CC0A08F95FB828BA75228B7B3D5FB91AC921B4C066B3869AAE83C6682C4FAA200755DF04FF18E771C06733D25A87D0530AD67CEDE50163E14D78F13FA4D0FF1EF621C7E8BD4BAF5EB0E6868540CDF5DCA4166DE4C2BC5E77DA458FD796DBBEB44420569C8F60D327289D4E64C23ABA375EBC4661A5BA49DD59D5F77EE79E378570C7429C7F508A8DD9013DB3E8E2133CC778CAA2A1FE5F59FE21B78B98C22C12771372169783620413FAB2BDCB245343BAC070C43D28F2DC909424A5DEC8500191DEDFBB085F0A56ADFD086043B5598615C3979DF408B5B06686CE47F88DDD143B8FEF319CC27E8D0CAC6CB9472A85D51654625DA206975ACE3C9BDF878A166017A898F9A282BB0EC7F6293D81E2EDAE4DF94F36D818018D676D368EE4A3DCE9768FB042C53772FFDDDA9E6F84C7BE2DDF69DC79DF5497A0DD36F9FC9FE248B2132AEE12BCD8CDF1ADFBCB912C27B2ED17158F7156806F0B5A669C00D5BD4D1389D582E9DCEBF68F36B7FF7820691F5492EA92D4CE44436385277850A7AB00371E1644427261555F5A08EACC0A35125547688CF66509FEF396E4CC948E8295D08B640266BFAA5B2CEBEB9620EDF3B67834757433074386E436C569A84F35A1CF205794AA29BB7BE9D8C1B7274971854C2C0A6F841AA996AB6E29361E51A9135FFC381294CEA1D566D7B405DBB6B8BA3497144A5E854E096DA1DD13BA2804367F30342F912471FD98966953088359FA28A56888C42E419FE281A447F65F8C8DFEF1C79AB0BFCE3434C4BA3D061FD345D10BBC886067ECD0EADE692BA7741673663CC2A24C16FBF15DE2448DCF7AF907952CF3285081892F9C7731FE0FB7DCB1915ECBD4C7AFA423B8D11568ED41F2C93B30AB120A5600D8C1CA7E627668E0509B1D6804A812B1391F1F3C8B331DF541E47390BB8F369A32843132BBEA954E040CBFE6FBC17C9B7B4B3E8C2965BBA9A20E0A5CE0C4DB7D503BF17AA1ECB7C8BD9EF4C325F9A3CE4898E9E69AFA15657568CC8CB093FB6B06671CCB0EA178E6B0DA339AA269BA97E7836B61B218996816611B227E27B39BD5969DBE7DC53DD4BE017FE63B0A78E8B2309A995568C0CFCD359B9F5143E22D05449D8AAECEB8D260CE2A5282CD3ACF6E547A939016C7B209E783DC3FB4275A956959C92F3B23FC15E9E8F27F70825EBDDF2B2D0CED25C5CE5ADAB6E624AB5D82894545975E201D35376E010ABA2CDBE0A6C6A95BC9F8EE5C09F39843D279588AD604D09C474D5ADFD4C0EDD90B4DBECC857798E46801FD2383F0E234027FA6E5F43E1EF7CA28980DC48D010244E48BF95612B78B4C4CA4F9DEF6E17320309A36F74C950B39C7F8A20A2ADEE443E37C01E1AFC56A0381C3E6F380A191DDF3A804A1E696F240FE0725DDB3AE1738AC0C943B67FF2965D5AB071F466B48289D4A62536210352FC3D38313EE07CB776F88447C26B15BCC498BA7AF001D1CC6834571DC300465AD6F99988EF29DF0D35443EAD0CEA8B3E97260E1111E40A70B02E59F1B65D66BF6461DA22FE217FD323581550DD5389668B257F250B7594E4C9F9671213626ADC995DBB99B58FE25FFB87FF676BB6829AE30DDE64CA8609CA38B070D1488F41513F0C9D9B62848CE1859C6E8E33986AB2A1CF69CDE0B7EC2C988F2E9522D933E85D4DF7A607E8997261D7AD156C60862835D5785F3F5A954726FD255245859088F4948E252B85DCC9105B5F7CDE2EACB203469780E47843A9BBA7F95B1E0BA2D513D4F20DC59A65938961683A09A00B1BE294FB96D21526B6772243B28A8152232CB110F4306EAD624CB1284D4B19F7B52F8158E1F18E1830BC4D31C4984D6586892DB71B959777DF5271B13BDC8FA3866FBC43FCAE311983B6057AA0FDEC4F56019BBCA28E7EE6BD40F9E8C56B602FE757A5C6D4E22B2FE8376552B299ACBB27D282FFDFE78816DA77F07467C6B4A7396F2D0A775C6A8E448A4B8B8725C8BAF4D430DAD533651166A20FFF3CD482122ED56F87A6B1DE6D4C9020B57651795FFA97E5E45E1898E3F960CDEF80C925F449D238E3838E836E3CE82897C7DCCFD800512F359FE9C18328CCA49441DE0C08D0419CF763943DB6FEEFD16091AF8F307CDEABD505D6CFF7D2D5A878434D96740FFC5D648B4A17AC96DA09CB95CBF81498DD4CCF91B9C4271FC2B4D4D457351ACB7A567587F5CF14088A3FC7967CCFFA233C462F09D303880059ED4C1A9638143FEE89AFAD723E74E8B38D5EB0270FD64406B6B816F0E0A85A9DA5D10F7FBEAF018E09A57A6B5550F402BDF52FD45F386C83B9822F77C058A8CA5D8E249A0BAD226301C7C0DCF887DC544EBD85EB0CB99C96DF93E9B7A20F764BF5591399E66FAF54AE1A6B3EC648D78224305F1234CCDDA5EA9CF9A46F1AE0FB8C905ACE2E45D23D2DFE3330DD3A594EF89829884CAB73E30DA48179B11C98D93CF37F25F169EEEC67824668CD6B11E56BF3286D909EEA8EE93779620FBBC5C9EFEB6EF36592B5E8CFC1A9C51A7B9F1537784CDB477D0AFEA8AC431C0D8D62EC8AA484A921DBE71B621B7F3F136AAB4D25F43D6449ADE513D6639B88A0E0E902620A48712A166CDEEBD5AE510713A49567FAC793899FE3BE7272E52F839BF4A68CE77B14F9B922F46E82FFA6E764F49B3D0A8833FBCCA595365878463546A1B5C296924709C738E3D20F8D6164A5174F9A0B8E3DD00099CBEF80D227300489230888B833E56292DD2C7B3A3F6CF65A68295B8E761397BA726E15A1E8AF665D1DED6792BD1FC3A64431DF890C610F942B0A80447E4AE1FD254F6A823BE8B30B740ABF54DF9A3576D574CC0C8F0619F522EE18E5369415E4FDE401023A50BF0F128B44B27D688DBEA296418434A08081F21088EDD0ABF43BDCCD71C1A36D8B825D0F1F55413D85BB200EFD43B973CA8F8F8C903C014593AACF35B9205A8648C95B42DE19AF22603E1913547DE57A0ADDDCDDA0E2E902FAB7F8DF80D3F1AE0BC3855D672348A5D43D7F9873C0A8C5AA2225088AB2FFFC7389038D13AC6A07C79954882647E5F63E7BCFAA8311985FB6EDE68858116835D99B3A5693DB2BA4EDD7300F5ED353F5E3190C16004984FA0547C4055395ABEA2E3012F9C4A3F61E1969037DFB0C081FBBA4287D7A7399B633B0B1289C0538869ACF45A7B4CCB54B90F80A35ED339932BF3423EE6E7FECCE071D5C5F5F94EE10356BEAD1B20C11C45202F90EB24632F087802102D2D49EC4210686EAA722AE28819C9895CF6866CBCF1A58658CADFF7F145294DF9C80B76E7A5CBCCEBF318470D5F8310F48BB036603DEC06227FE86491D3DA50BFE847EE2E83E96F0380D46F53E030A873F2F46C725FFAAF23F5E7A0E519B3C8D0C108E9AD98E83AA8D17B6AEAC13110DAAB346607245F93F34F1AAB14CF5A918989B37E8B9A1E600F749C50F4021E121088DEB17C12D943720C1D54CEFD5AC25CD59A221E98F0360299AAFFB09C0E5C4CFDB6487BAD871E17CF23F21F068887DEE455CD1B7F9482310802E1C9233130BF11863429E1AE163056EA5E7FD5B9CB4E868B908AF6ACE2D1E8CCBB563A959CC8A4DA464EA8E472FE41E11895D3371C194E549288D7491F338CA9BA81CFDC8062AB426FBE6EEA747AD2FD7BBD3AF98407A5F0DE21BEEADD13E390D6882EE808D88B9FBE78A3115DDF1C7F276B5F68CFB6BB52D66802CD8384BD27590D1377A14933C432748F7A3613778898197133D4547BCC47480DA91D4AD9D0FFC2BC3CB5C51B544BC28C8E37CE12ECF8ED3127F717EA691BCE47D3CBDD93CD8D6F56DC36C993C45E8852AE6A21D726A6908EC91E502FB0BFC347B333C6AE9F56C19E040304EA97BD1A5117D0AB42B6D860B23CAFEF472206074134678F3CB024A6F10837A0DD2FFE3EF37582A2799866D820C9EE8E89BE7A0F785483B44706DCE0E2F093E999943EF4F2697329780A55B26275AA8FA6B205D32B1FB1BD104B88CE6633E0B5460A40210776646B6C638B62C105CFFD2BA64C30D47711F178F5946FEA81061CAFFA745D39D900C2C5DA2E0D7E70717FE266FED904729CA958056A838E5611E3A8C8ABADB56CAC1456887A6FAECE484032A5937C38491E2E55784389D2F8992374964F0A62B9B399FEAA6F92EAC5BA0847065DA7D7C9B9BBC8B0F7B8B5E483B46DDFE35AB212AA3B5156677F5D43BEA401F637D82AFE43824B61397DBABD2D92660132C630028B6D05C00DAC3323EEB3DAC025BA1A06C54A22B25C464D413B7D3973DCC7A0B17873455F5D2CED5F84479887277FD55FDAAFC0B5131C3886AC1717C08F4DC9B56F9AB3BD2DD5C4B8CAEA10BB2CE98830D40E520C27FBE7C737CA5D7F6EBEE5731622BB6A0C8D76253AE25B1CC490A336ECEEC30ED08A608146351BF15A533E2ED7C78DAA027DFBD7E37BCC595130D4FCF268E27CE2DE144516C";

        System.out.println(Integer.parseInt("000A", 16));
        List<String> list = new ArrayList<>();
        list.add(jsss);
        byte[] convert = convertArrayListToByteArray(list);
        System.out.println(Arrays.toString(convert));
        List<String> sss = convertByteArrayToArrayList(convert);
        System.out.println(sss.get(0));
//        System.out.println(AuxUtils.b2s(AuxUtils.h2b("000D")));
//
//
//        System.out.println(AuxUtils.b2s(AuxUtils.h2b("001C")));
//        //AuxUtils.b2h(Iso9797Util.iso7816d4Pad(AuxUtils.h2b(data)))
//
//
//        System.out.println("-----   "+AuxUtils.b2h(AuxUtils.h2b("B64040000000000080000000000000000840084015082100010203042200000000000000")[28]));
//        System.out.println(AuxUtils.b2h((byte)34));
//        System.out.println(AuxUtils.h2b("B64040000000000080000000000000000840084015082100010203042200000000000000").length);
//        byte[] padded = iso7816d4Pad(AuxUtils.h2b(rawData));
//        String rawDataPadded = AuxUtils.b2h(padded);
//
//        //2200
//        System.out.println("rawdataPadded " + rawDataPadded);
//        System.out.println("rawdataPadded " + rawDataPadded.length());
//        String result = iso9797Alg3(otpKey2, rawDataPadded);
//        System.out.println(result);

    }

}
