import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.poker.protocols.im.ImMessageProto;

public class Main {

	public static void main(String []argc){
		testImMessage();
	}
	
	public static void testImMessage(){
		
		// ���ն�������ݽṹ������һ��Person  
		ImMessageProto.ImMessage.Builder builder = ImMessageProto.ImMessage.newBuilder();
		builder.setType(1);
		builder.setText("Im123456789");
		
		// ������д�����������������������������ByteArrayOutputStream������  
		ByteArrayOutputStream output = new ByteArrayOutputStream(16*1024);
		ImMessageProto.ImMessage obj = builder.build();
		try {
			obj.writeTo(output);
			//op.write(obj.toByteArray())
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// -------------- �ָ��ߣ������Ƿ��ͷ������������л����� ---------------  
		byte[] byteArray = output.toByteArray(); 
		System.out.println(" output length " + byteArray.length + " toString " + new String(byteArray));
		
		
		 // -------------- �ָ��ߣ������ǽ��շ��������ݽ��պ����л� ---------------  
        
        // ���յ�������ȡ����������������������ByteArrayInputStream������  
        ByteArrayInputStream input = new ByteArrayInputStream(byteArray);
        try {
        	ImMessageProto.ImMessage readObj = ImMessageProto.ImMessage.parseFrom(input);
			
			System.out.println(" input length " + byteArray.length + " toString " + readObj.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}
}
