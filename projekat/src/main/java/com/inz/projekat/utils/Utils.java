package com.inz.projekat.utils;

import com.ugos.jiprolog.engine.JIPEngine;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Transactional(isolation = Isolation.SERIALIZABLE)

@Component
public class Utils {

    private static JIPEngine jipEngine = new JIPEngine();

    private static boolean consulted = false;


    public JIPEngine getJipEngine() {
        if (jipEngine == null){
            jipEngine = new JIPEngine();
        }else if (!consulted){
            consulted = true;
            jipEngine.consultFile("corpus.pl");
        }
        return jipEngine;
    }

    public Utils() {
    }
}
