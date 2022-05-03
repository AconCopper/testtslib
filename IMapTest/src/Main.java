
import org.toxsoft.core.tslib.*;
import static org.toxsoft.core.tslib.utils.TsTestUtils.*;

import java.util.Iterator;
import java.util.Map;
import java.awt.RenderingHints.Key;
import java.lang.*;

import org.toxsoft.core.tslib.coll.IList;
import org.toxsoft.core.tslib.coll.IListBasicEdit;
import org.toxsoft.core.tslib.coll.IMap;
import org.toxsoft.core.tslib.coll.IMapEdit;
import org.toxsoft.core.tslib.coll.impl.ElemArrayList;
import org.toxsoft.core.tslib.coll.impl.ElemMap;

public class Main {
	
	public static void main(String[] args) {
		IMapEdit<String, Integer> map = new ElemMap<>();
		boolean notYet = true;
		while (notYet) {
			map.put(waitEnter("Enter var name\n"), Integer.parseInt(waitEnter("Enter ver value\n")));		
			if (waitEnter("Another var? y/n\n").equals("n")) {
				notYet = false;
			} 
		}
			Integer sqrSumm = 0;
			for (Integer i : map.values()) {
				 sqrSumm += i*i;
			}
			double fin = Math.sqrt(sqrSumm);
			p("%s=sqrt(",String.valueOf(fin));
			
//			Iterator<String> iter = map.keys().iterator();
//			if(iter.hasNext()) {
//				p("%s^2+",iter.toString()));
//			}else {
//				p("%s^2)",iter.toString());
//			}
			for (String str : map.keys()) {
				if(str != map.keys().last()) {
					p("%s^2+", str);	
				} else {
					p("%s^2)", str);
				}
			}
	}
}
