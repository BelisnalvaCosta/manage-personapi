package Dio.Santander.managepersonapi;

import org.mapstruct.TargetType;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static sun.security.krb5.internal.crypto.Nonce.value;

@Target({ElementType.TYPE})
@Retention(Retention.RUNTIME)
@Documented
@Controller
@ResponseBody
public @interface RestController {
    @AliasFor(
            annotation = Controller.class
    )
    String value() default "";
}
