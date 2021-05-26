package factory;

public class OsFactory {
    public static Os getOsObject(String type) {
        if (type.equalsIgnoreCase("open"))
            return new Andriod();
        else if (type.equalsIgnoreCase("closed"))
            return new Ios();
        else
            return new Windows();
    }
}
