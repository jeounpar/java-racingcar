import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputText {

    private static final String DEFAULT_SEPARATORS = ",|:";
    private static final String CUSTOM_SEPARATOR_FINDERS = "//(.)\n(.*)";

    private final String text;
    private final Pattern pattern;

    public InputText(String text) {
        this.text = text;
        this.pattern = Pattern.compile(CUSTOM_SEPARATOR_FINDERS);
    }

    public static InputText from(String text){
        return new InputText(text);
    }

    public boolean isBlank() {
        return this.text == null || this.text.isEmpty();
    }

    private boolean hasCustomSeparator(){
        return pattern.matcher(this.text).matches();
    }

    public String[] split(){
        if(hasCustomSeparator()){
            Matcher matcher = pattern.matcher(this.text);
            matcher.find();
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return this.text.split(DEFAULT_SEPARATORS);
    }
}
