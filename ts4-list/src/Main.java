
import org.toxsoft.core.tslib.*;
import static org.toxsoft.core.tslib.utils.TsTestUtils.*;

import org.toxsoft.core.tslib.coll.IList;
import org.toxsoft.core.tslib.coll.IListBasicEdit;
import org.toxsoft.core.tslib.coll.impl.ElemArrayList;

public class Main {
	
	public static void main(String[] aArgs) {
//		IListBasicEdit<Integer> list = new ElemArrayList<>();
//		for(int i = 0; i < 5; i++) {
//			String input = waitEnter("Enter number #%d\n", i+1);
//			list.add(Integer.parseInt(input));
//		}
//		for(int i = 0; i < list.size(); i++) {
//			pl(list.get(i).toString());
//		}
		IListBasicEdit<String> list = new ElemArrayList<>();
		for(int i = 0; i < 3; i++) {
			String input = waitEnter("Enter string #%d\n", i+1);
			list.add(input);
		}
		for(int i = 0; i < list.size(); i++) {
			pl(list.get(i));
		}
		for(int i = 0; i < list.size(); i++) {
			pl(list.get(list.size()-1-i));
		}
	}
}
