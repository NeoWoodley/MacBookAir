//package Property;
//
//import java.lang.reflect.Method;
//
//public class Try {
//	public static void main(String[] args) throws SecurityException, ClassNotFoundException {
//		String clazz = "AnnotationDemo";
//		Method[] demoMethod = AnnotationParser.class.getClassLoader().loadClass(clazz).getMethods();
//
//		for (Method method : demoMethod) {
//			if (method.isAnnotationPresent(AuthorAnno.class)) {
//				AuthorAnno annotationInfo = method.getAnnotation(AuthorAnno.class);
//				System.out.println("method: " + method);
//				System.out.println("name= " + annotationInfo.name() +
//						" , website= " + annotationInfo.website()
//						+ " , revision= " + annotationInfo.revision());
//			}
//		}
//	}
//}
