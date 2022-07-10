package numbers;

public class NumberObject {
    private long value;
    private boolean isEven;
    private boolean isOdd;
    private boolean isBuzz;
    private boolean isDuck;
    private boolean isPalindromic;
    private boolean isGapful;
    private boolean isSpy;
    private boolean isSquare;
    private boolean isSunny;
    private boolean isJumping;
    private boolean isHappy;
    private boolean isSad;

    private static final String propertyNames = "even odd buzz duck palindromic gapful spy square sunny";

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public boolean isEven() {
        return isEven;
    }

    public void setEven(boolean even) {
        isEven = even;
    }

    public boolean isOdd() {
        return isOdd;
    }

    public void setOdd(boolean odd) {
        isOdd = odd;
    }

    public boolean isBuzz() {
        return isBuzz;
    }

    public void setBuzz(boolean buzz) {
        isBuzz = buzz;
    }

    public boolean isDuck() {
        return isDuck;
    }

    public void setDuck(boolean duck) {
        isDuck = duck;
    }

    public boolean isPalindromic() {
        return isPalindromic;
    }

    public void setPalindromic(boolean palindromic) {
        isPalindromic = palindromic;
    }

    public boolean isGapful() {
        return isGapful;
    }

    public void setGapful(boolean gapful) {
        isGapful = gapful;
    }

    public boolean isSpy() {
        return isSpy;
    }

    public void setSpy(boolean spy) {
        isSpy = spy;
    }

    public boolean isSquare() {
        return isSquare;
    }

    public void setSquare(boolean square) {
        isSquare = square;
    }

    public boolean isSunny() {
        return isSunny;
    }

    public void setSunny(boolean sunny) {
        isSunny = sunny;
    }

    public boolean isJumping() {
        return isJumping;
    }

    public void setJumping(boolean jumping) {
        isJumping = jumping;
    }

    public boolean isHappy() {
        return isHappy;
    }

    public void setHappy(boolean happy) {
        isHappy = happy;
    }

    public boolean isSad() {
        return isSad;
    }

    public void setSad(boolean sad) {
        isSad = sad;
    }

    public void printProperties(){
        System.out.printf("Properties of %,d\n", value);

        System.out.printf("       buzz: %s\n", isBuzz);
        System.out.printf("       duck: %s\n", isDuck);
        System.out.printf("palindromic: %s\n", isPalindromic);
        System.out.printf("     gapful: %s\n", isGapful);
        System.out.printf("        spy: %s\n", isSpy);
        System.out.printf("     square: %s\n", isSquare);
        System.out.printf("      sunny: %s\n", isSunny);
        System.out.printf("    jumping: %s\n", isJumping);
        System.out.printf("      happy: %s\n", isHappy);
        System.out.printf("        sad: %s\n", isSad);

        System.out.printf("       even: %s\n", isEven);
        System.out.printf("        odd: %s\n", isOdd);

    }

    public void setProperties(){
        boolean checkFlag = NumberUtils.isEvenNumber(this.value);
        boolean checkHappy = NumberUtils.isHappyNumber(this.value);
        setEven(checkFlag);
        setOdd(!checkFlag);
        setBuzz(NumberUtils.isBuzzNumber(this.value));
        setDuck(NumberUtils.isDuckNumber(this.value));
        setPalindromic(NumberUtils.isPalindromNumber(this.value));
        setGapful(NumberUtils.isGapfulNumber(this.value));
        setSpy(NumberUtils.isSpyNumber(this.value));
        setSquare(NumberUtils.isSquareNumber(this.value));
        setSunny(NumberUtils.isSunnyNumber(this.value));
        setJumping(NumberUtils.isJumping(this.value));
        setHappy(checkHappy);
        setSad(!checkHappy);
    }

    public String toString(){
        StringBuilder text = new StringBuilder("             " + this.value + " is ");

        if (isBuzz) {
            text.append("buzz, ");
        }

        if (isDuck) {
            text.append("duck, ");
        }

        if (isPalindromic) {
            text.append("palindromic, ");
        }

        if (isGapful) {
            text.append("gapful, ");
        }

        if (isSpy) {
            text.append("spy, ");
        }

        if (isSquare) {
            text.append("square, ");
        }

        if (isSunny) {
            text.append("sunny, ");
        }

        if (isJumping) {
            text.append("jumping, ");
        }

        if (isHappy) {
            text.append("happy, ");
        }

        if (isSad) {
            text.append("sad, ");
        }

        if (isEven) {
            text.append("even");
        }

        if (isOdd){
            text.append("odd");
        }

        return text.toString();
    }
}
