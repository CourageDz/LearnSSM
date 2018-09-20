package Chapter11.aop.aspect;


import Chapter11.aop.verifier.RoleVerifier;
import Chapter11.aop.verifier.impl.RoleVerifierImpl;
import Chapter11.game.pojo.Role;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class RoleAspect {
	
	@DeclareParents(value= "Chapter11.aop.service.impl.RoleServiceImpl+", defaultImpl=RoleVerifierImpl.class)
	public RoleVerifier roleVerifier;

	@Pointcut("execution(* Chapter11.aop.service.impl.RoleServiceImpl.printRole(..))")
	public void print() {
	}

	@Before("print()")
	// @Before("execution(*
	// Chapter11.aop.service.impl.RoleServiceImpl.printRole(..))")
	public void before() {
		System.out.println("before ....");
	}

	@After("print()")
	// @After("execution(*
	// Chapter11.aop.service.impl.RoleServiceImpl.printRole(..))")
	public void after() {
		System.out.println("after ....");
	}

	@AfterReturning("print()")
	// @AfterReturning("execution(*
	// Chapter11.aop.service.impl.RoleServiceImpl.printRole(..))")
	public void afterReturning() {
		System.out.println("afterReturning ....");
	}

	@AfterThrowing("print()")
	// @AfterThrowing("execution(*
	// Chapter11.aop.service.impl.RoleServiceImpl.printRole(..))")
	public void afterThrowing() {
		System.out.println("afterThrowing ....");
	}

	@Around("print()")
	public void around(ProceedingJoinPoint jp) {
		System.out.println("around before ....");
		try {
			jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("around after ....");
	}

	@Before("execution(* Chapter11.aop.service.impl.RoleServiceImpl.printRole(..)) " + "&& args(role, sort)")
	public void before(Role role, int sort) {
		System.out.println("before ....");
	}
}
