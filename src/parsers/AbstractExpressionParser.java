package parsers;

import model.*;

public abstract class AbstractExpressionParser {

    public AbstractExpressionParser() {

    }

    public abstract Expression parse(String myInput, int myCurrentPosition,
            Parser ps);

    public abstract int updatePosition();
}
