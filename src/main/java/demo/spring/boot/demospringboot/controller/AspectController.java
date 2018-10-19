package demo.spring.boot.demospringboot.controller;

/**
 * 继承这个接口的class，在切面aop方法执行前后，调用此接口的方法
 */
public interface AspectController {

    void BeforeAspectMethod();

    void AfterAspectMethod();

}
