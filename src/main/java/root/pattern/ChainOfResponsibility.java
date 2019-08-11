package root.pattern;

import java.text.MessageFormat;
import java.util.Objects;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        OutHandler handler3 = new OutHandler(3, null);
        OutHandler handler2 = new OutHandler(2, handler3);
        OutHandler handler1 = new OutHandler(1, handler2);

        handler1.handle(Thread.currentThread().getName());
    }
}

interface Handler {
    void handle(Object object);
}

abstract class AbstractHandler implements Handler {
    private final Handler next;

    protected AbstractHandler(Handler next) {
        this.next = next;
    }

    @Override
    public void handle(Object object) {
        if (Objects.nonNull(next)) {
            next.handle(object);
        }
    }
}

class OutHandler extends AbstractHandler {

    private final int number;

    protected OutHandler(int number, Handler next) {
        super(next);
        this.number = number;
    }

    @Override
    public void handle(Object object) {
        System.out.println(MessageFormat.format("Num = {0} Obj = {1}", number, object));
        super.handle(object);
    }
}