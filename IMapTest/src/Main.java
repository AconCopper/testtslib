
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
import org.toxsoft.core.tslib.coll.primtypes.IStringMap;
import org.toxsoft.core.tslib.coll.primtypes.IStringMapEdit;
import org.toxsoft.core.tslib.coll.primtypes.impl.StringMap;

public class Main {
	
	public static void main(String[] args) {
		IStringMapEdit<Integer> map = new StringMap();
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
			p("%.2f=sqrt(", Double.parseDouble(String.valueOf(fin)));
			for (String str : map.keys()) {
				if(str != map.keys().last()) {
					p("%s^2+", str);	
				} else {
					p("%s^2)", str);
				}
			}
	}
}
