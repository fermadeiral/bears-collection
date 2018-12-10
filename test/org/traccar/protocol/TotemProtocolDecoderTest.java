package org.traccar.protocol;

import org.junit.Test;
import org.traccar.ProtocolTest;

public class TotemProtocolDecoderTest extends ProtocolTest {

    @Test
    public void testDecode() throws Exception {

        TotemProtocolDecoder decoder = new TotemProtocolDecoder(new TotemProtocol());

        verifyPosition(decoder, text(
                "$$0108AB863835028447675|5004C0001710250234064214059828A058AE121010604000.600000320304.7772N10134.8238E11625B"));

        verifyPosition(decoder, text(
                "$$0108AA863835028447675|5004C0001710250234134114057728A058AE112108305100.600000660304.7787N10134.8719E116458"));

        verifyPosition(decoder, text(
                "$$0112AA864244026065291|180018001409160205244011000027BA0E57063100000001.200000002237.8119N11403.5075E05202D"));

        verifyPosition(decoder, text(
                "$$0116AA864244026065291|18001800140916020524401100000000000027BA0E57063100000001.200000002237.8119N11403.5075E052020"));

        verifyPosition(decoder, text(
                "$$0116AA867119025683137|108000001611020925324112000000000000616027F7001300000099.900000000000.0000N00000.0000E531824"));

        verifyPosition(decoder, text(
                "$$0128AA864244026065291|18001800140916020524401100000000000000000000000027BA0E57063100000001.200000002237.8119N11403.5075E05202D"));

        verifyPosition(decoder, text(
                "$$0128AA867965024919124|10010800160223032415401203270321032103270189000027BA0E4E001800200001.000000002237.7581N11403.5088E000957"));

        verifyPosition(decoder, text(
                "$$0108AA863835024426319|18004000160216160756411100007DCD0000111000000000.800000000316.3519N10228.5086E126522"));

        verifyPosition(decoder, text(
                "$$0128AA867521029231005|1880100015101802314842140000000000000000000000001AB48366093127600000.900000000806.1947N09818.4795E080355"));

        verifyPosition(decoder, text(
                "$$0108AA864244026063437|1A0000001401010101014111000027BA0E57003100000000.000000000000.0000N00000.0000E048156"));

        verifyPosition(decoder, text(
                "$$BE863771024392112|AA$GPRMC,044704.000,A,1439.3334,N,12059.1417,E,0.00,0.00,200815,,,A*67|01.7|00.8|01.4|000000000000|20150820044704|14291265|00000000|4EECBF8B31|0000|0.0000|0002|00000|56E7"),
                position("2015-08-20 04:47:04.000", true, 14.65556, 120.98570));

        verifyPosition(decoder, text(
                "$$AE860990002922822|AA$GPRMC,051002.00,A,0439.26245,N,10108.94448,E,0.023,,140315,,,A*71|02.98|01.95|02.26|000000000000|20150314051003|13841157|105A3B1C|0000|0.0000|0005|5324"),
                position("2015-03-14 05:10:02.000", true, 4.65437, 101.14907));

        verifyPosition(decoder, text(
                "$$AE860990002922822|AA$GPRMC,051002.00,A,0439.26245,N,10108.94448,E,0.023,,140315,,,A*71|02.98|01.95|02.26|000000000000|20150314051003|13841157|105A3B1C|0000|0.0000|0005|5324\r"));

        verifyNull(decoder, text(
                "$$BB862170017856731|AA$GPRMC,000000.00,V,0000.0000,N,00000.0000,E,000.0,000.0,000000,,,A*73|00.0|00.0|00.0|000000001000|20000000000000|13790000|00000000|00000000|00000000|0.0000|0007|8C23"));

        verifyPosition(decoder, text(
                "$$B8862170017856731|AA$GPRMC,171849.00,A,3644.9893,N,01012.9927,E,0.049,51,200813,,,A*73|1.59|0.97|1.25|100000001000|20130820171849|13690000|00000000|019BD508|00000000|0.0000|0026|1B2C"));

        verifyPosition(decoder, text(
                "$$B2359772032984289|AA$GPRMC,104446.000,A,5011.3944,N,01439.6637,E,0.00,,290212,,,A*7D|01.8|00.9|01.5|000000100000|20120229104446|14151221|00050000|046D085E|0000|0.0000|1170|29A7"));

        verifyPosition(decoder, text(
                "$$8B862170017861566|AA180613080657|A|2237.1901|N|11402.1369|E|1.579|178|8.70|100000001000|13811|00000000|253162F5|00000000|0.0000|0014|2B16"),
                position("2013-06-18 08:06:57.000", true, 22.61984, 114.03562));

        verifyPosition(decoder, text(
                "$$72862170017856731|3913090911165280000370000000000000000019BD508A0400000003.400000093644.9817N01012.9944E00506F2E"));

        verifyPosition(decoder, text(
                "$$B0456123|61$GPRMC,114725.00,A,1258.68276,N,07730.60237,E,0.410,,080113,,,A*79|1.44|0.66|1.27|000000000000|20130108114425|03600000|00000000|053C2BFE|0000|0.3325|0063|2005"));

        verifyNull(decoder, text(
                "$$AE359772033395899|AA000000000000000000000000000000000000000000000000000000000000|00.0|00.0|00.0|000000000000|20090215000153|13601435|00000000|00000000|0000|0.0000|0007|2DAA"));

        verifyNull(decoder, text(
                "$$AE359772033395899|AA000000000000000000000000000000000000000000000000000000000000|00.0|00.0|00.0|00000000|20090215001204|14182037|00000000|0012D888|0000|0.0000|0016|5B51"));

        verifyNull(decoder, text(
                "$$AE359772033395899|AA00000000000000000000000000000000000000000000000000000000000|00.0|00.0|00.0|00000000000|20090215001337|14182013|00000000|0012D888|0000|0.0000|0017|346E"));

        verifyPosition(decoder, text(
                "$$B3359772032399074|60$GPRMC,094859.000,A,3648.2229,N,01008.0976,E,0.00,,221211,,,A*79|02.3|01.3|02.0|000000000000|20111222094858|13360808|00000000|00000000|0000|0.0000|0001||A977"));

        verifyPosition(decoder, text(
                "$$B3359772032399074|09$GPRMC,094905.000,A,3648.2229,N,01008.0976,E,0.00,,221211,,,A*71|02.1|01.3|01.7|000000000000|20111222094905|03210533|00000000|00000000|0000|0.0000|0002||FA58"));

        verifyPosition(decoder, text(
                "$$B3359772032399074|AA$GPRMC,093911.000,A,3648.2146,N,01008.0977,E,0.00,,140312,,,A*7E|02.1|01.1|01.8|000000000000|20120314093910|04100057|00000000|0012D887|0000|0.0000|1128||C50E"));

        verifyPosition(decoder, text(
                "$$B3359772032399074|AA$GPRMC,094258.000,A,3648.2146,N,01008.0977,E,0.00,,140312,,,A*7F|02.1|01.1|01.8|000000000000|20120314094257|04120057|00000000|0012D887|0000|0.0000|1136||CA32"));

        verifyPosition(decoder, text(
                "$$B3359772032399074|AA$GPRMC,234603.000,A,3648.2179,N,01008.0962,E,0.00,,030412,,,A*74|01.8|01.0|01.5|000000000000|20120403234603|14251914|00000000|0012D888|0000|0.0000|3674||940B"));

        verifyPosition(decoder, text(
                "$$B3359772032399074|AA$GPRMC,234603.000,A,3648.2179,N,01008.0962,E,0.00,,030412,,,A*74|01.8|01.0|01.5|000000000000|20120403234603|14251914|00000000|0012D888|0000|0.0000|3674|940B"));
        
        verifyPosition(decoder, text(
                "$$B2356895037578518|AA$GPRMC,173829.000,A,3740.4107,N,02129.9815,E,0.00,,111113,,,A*7B|02.6|01.6|02.1|000000000000|20131111173829|14041251|00000000|002E0DD7|0000|0.0240|6010|8128"));

        verifyPosition(decoder, text(
                "$$B2356895037578518|AA$GPRMC,203823.000,A,3740.3285,N,02129.9295,E,0.00,,111113,,,A*79|01.5|01.0|01.1|000000000000|20131111203823|14041251|00000000|002E0DD7|0000|0.0000|6371|3824"));

    }

}
