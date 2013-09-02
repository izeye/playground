package com.izeye.playground.math.controller;

import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_COLLATZ;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_FACTORIAL;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_FIBONACCI;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_GCD_AND_LCM;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_GOLDBACH;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_MEAN;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_PRIME_ALL_PRIMES;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_PRIME_FACTORIZATION;
import static com.izeye.playground.support.menu.domain.MenuConstants.API_PATH_PRIME_IS_PRIME;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_COLLATZ_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_FACTORIAL_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_FIBONACCI_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_GCD_AND_LCM_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_GOLDBACH_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_MEAN_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_PRIME_FACTORIZATION_PATH;
import static com.izeye.playground.support.menu.domain.MenuConstants.SUB_MENU_ITEM_PRIME_PATH;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.izeye.playground.support.math.collatz.service.CollatzConjectureSolver;
import com.izeye.playground.support.math.factorial.service.FactorialSolver;
import com.izeye.playground.support.math.fibonacci.service.FibonacciNumberSolver;
import com.izeye.playground.support.math.gcd.domain.GcdAndLcm;
import com.izeye.playground.support.math.gcd.service.GcdAndLcmSolver;
import com.izeye.playground.support.math.goldbach.domain.GoldbachPartition;
import com.izeye.playground.support.math.goldbach.service.GoldbachConjectureSolver;
import com.izeye.playground.support.math.mean.domain.MeanType;
import com.izeye.playground.support.math.mean.service.MeanCalculator;
import com.izeye.playground.support.math.prime.domain.PrimeFactor;
import com.izeye.playground.support.math.prime.service.PrimeSolver;
import com.izeye.playground.support.menu.domain.SubMenuItem;

@Controller
public class MathAlgebraController extends AbstractMathController {

	@Resource
	private PrimeSolver primeSolver;

	@Resource
	private GcdAndLcmSolver gcdAndLcmSolver;

	@Resource
	private FactorialSolver factorialSolver;

	@Resource
	private FibonacciNumberSolver fibonacciNumberSolver;

	@Resource
	private GoldbachConjectureSolver goldbachConjectureSolver;

	@Resource
	private CollatzConjectureSolver collatzConjectureSolver;

	@Resource
	private MeanCalculator meanCalculator;

	@RequestMapping(SUB_MENU_ITEM_PRIME_PATH)
	public String mathPrime(Model model) {
		model.addAttribute("API_PATH_PRIME_IS_PRIME", API_PATH_PRIME_IS_PRIME);
		model.addAttribute("API_PATH_PRIME_ALL_PRIMES",
				API_PATH_PRIME_ALL_PRIMES);

		return SubMenuItem.MATH_ALGEBRA_PRIME.getViewName();
	}

	@RequestMapping(API_PATH_PRIME_IS_PRIME)
	@ResponseBody
	public boolean primeIsPrimeApi(@RequestParam Long number) {
		return primeSolver.isPrime(number);
	}

	@RequestMapping(API_PATH_PRIME_ALL_PRIMES)
	@ResponseBody
	public List<Long> primeAllPrimeApi(@RequestParam Long number) {
		return primeSolver.getAllPrimesWithin(number);
	}

	@RequestMapping(SUB_MENU_ITEM_PRIME_FACTORIZATION_PATH)
	public String primeFactorization(Model model) {
		model.addAttribute("API_PATH_PRIME_FACTORIZATION",
				API_PATH_PRIME_FACTORIZATION);

		return SubMenuItem.MATH_ALGEBRA_PRIME_FACTORIZATION.getViewName();
	}

	@RequestMapping(API_PATH_PRIME_FACTORIZATION)
	@ResponseBody
	public List<PrimeFactor> primeFactorizationApi(@RequestParam Long number) {
		return primeSolver.getPrimeFactors(number);
	}

	@RequestMapping(SUB_MENU_ITEM_GCD_AND_LCM_PATH)
	public String gcdAndLcm(Model model) {
		model.addAttribute("API_PATH_GCD_AND_LCM", API_PATH_GCD_AND_LCM);

		return SubMenuItem.MATH_ALGEBRA_GCD_AND_LCM.getViewName();
	}

	@RequestMapping(API_PATH_GCD_AND_LCM)
	@ResponseBody
	public GcdAndLcm gcdAndLcmApi(@RequestParam Long number1,
			@RequestParam Long number2) {
		return gcdAndLcmSolver.getGcdAndLcm(number1, number2);
	}

	@RequestMapping(SUB_MENU_ITEM_FACTORIAL_PATH)
	public String factorial(Model model) {
		model.addAttribute("API_PATH_FACTORIAL", API_PATH_FACTORIAL);

		return SubMenuItem.MATH_ALGEBRA_FACTORIAL.getViewName();
	}

	@RequestMapping(API_PATH_FACTORIAL)
	@ResponseBody
	public String factorialApi(@RequestParam BigInteger number) {
		String result = factorialSolver.solve(number).toString();
		return result;
	}

	@RequestMapping(SUB_MENU_ITEM_FIBONACCI_PATH)
	public String fibonacci(Model model) {
		model.addAttribute("API_PATH_FIBONACCI", API_PATH_FIBONACCI);

		return SubMenuItem.MATH_ALGEBRA_FIBONACCI.getViewName();
	}

	@RequestMapping(API_PATH_FIBONACCI)
	@ResponseBody
	public List<Long> fibonacciApi(@RequestParam Long number) {
		return fibonacciNumberSolver.solve(number);
	}

	@RequestMapping(SUB_MENU_ITEM_GOLDBACH_PATH)
	public String goldbach(Model model) {
		model.addAttribute("API_PATH_GOLDBACH", API_PATH_GOLDBACH);

		return SubMenuItem.MATH_ALGEBRA_GOLDBACH.getViewName();
	}

	@RequestMapping(API_PATH_GOLDBACH)
	@ResponseBody
	public List<GoldbachPartition> goldbachApi(@RequestParam Long number) {
		return goldbachConjectureSolver.solve(number);
	}

	@RequestMapping(SUB_MENU_ITEM_COLLATZ_PATH)
	public String collatz(Model model) {
		model.addAttribute("API_PATH_COLLATZ", API_PATH_COLLATZ);

		return SubMenuItem.MATH_ALGEBRA_COLLATZ.getViewName();
	}

	@RequestMapping(API_PATH_COLLATZ)
	@ResponseBody
	public List<Long> collatzApi(@RequestParam Long number) {
		return collatzConjectureSolver.solve(number);
	}

	@RequestMapping(SUB_MENU_ITEM_MEAN_PATH)
	public String mean(Model model) {
		model.addAttribute("meanTypes", MeanType.values());

		model.addAttribute("API_PATH_MEAN", API_PATH_MEAN);

		return SubMenuItem.MATH_ALGEBRA_MEAN.getViewName();
	}

	@RequestMapping(API_PATH_MEAN)
	@ResponseBody
	public BigDecimal meanAPi(@RequestParam MeanType meanType,
			@RequestParam String numbers) {
		List<BigDecimal> numberList = new ArrayList<BigDecimal>();
		for (String number : numbers.split(",")) {
			numberList.add(BigDecimal.valueOf(Double.parseDouble(number)));
		}
		return meanCalculator.calculate(meanType, numberList);
	}

}
