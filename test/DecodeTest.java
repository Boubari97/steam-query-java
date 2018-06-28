import org.junit.jupiter.api.Test;
import steam.*;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecodeTest {

    @Test
    public void decodeTest() throws IOException {
        byte[] response = {(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0x66, (byte) 0x0A, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00};

        DatagramPacket packet = new DatagramPacket(response, response.length);

        MasterServer ms = new MasterServer(MasterServers.SOURCE);

        ArrayList<InetSocketAddress> res = ms.parseResponse(packet);

        assertEquals("255.255.255.255", res.get(0).getAddress().getHostAddress());
        assertEquals("0.0.0.0", res.get(1).getAddress().getHostAddress());
    }

}
