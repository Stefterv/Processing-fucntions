package func;
import processing.core.*;

public class func implements PConstants{
	PApplet parent;
	public PVector mouse;
	public func(PApplet parent){
		this.parent = parent;
		parent.registerMethod("pre", this);
	}
	public void pre(){
		mouse = new PVector(parent.mouseX,parent.mouseY);
	}
	public static void printTest(){
		PApplet.println("Test");
	}
	public static float fit(float value, float min, float max, float start, float end){
		if(start<end){
			return PApplet.constrain(PApplet.map(value,min,max,start,end),start,end);
		}else{
			return PApplet.constrain(PApplet.map(value,min,max,start,end),end,start);
		}
	}
	public static float grid(float value, float marker){
		return PApplet.floor(value/marker)*marker;
	}
	public void translate(PVector p){
		if(parent.g.is2D()){
			parent.translate(p.x,p.y);
		}else{
			parent.translate(p.x,p.y,p.z);
		}
	}
	public void vertex(PVector p){
		if(parent.g.is2D()){
			parent.vertex(p.x,p.y);
		}else{
			parent.vertex(p.x,p.y,p.z);
		}
	}
	public void point(PVector p){
		if(parent.g.is2D()){
			parent.point(p.x,p.y);
		}else{
			parent.point(p.x,p.y,p.z);
		}
	}
	public static <T> T last(T[] array) {
    return array[array.length - 1];
	}
	public void disable3D(){
		parent.camera();
		parent.hint(DISABLE_DEPTH_TEST);
	}
	public void enable3D(){
		parent.hint(ENABLE_DEPTH_TEST);
		parent.camera(0,0,1000,0,0,0,0,1,0);
	}
	public static <T> T[] remove(T[] array, T obj) {
		int index = indexOf(obj,array);
		if(index<0){
			return array;
		}
		T[] a1 = (T[]) PApplet.subset(array,0,index);
		T[] a2 = (T[]) PApplet.subset(array,index+1);
		return (T[]) PApplet.concat(a1,a2);
	}
	public static <T> int indexOf(T needle, T[] haystack){
	    for (int i=0; i<haystack.length; i++){
	        if (haystack[i] != null && haystack[i].equals(needle)
	            || needle == null && haystack[i] == null) return i;
	    }
	    return -1;
	}
}
