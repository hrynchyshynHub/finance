package com.hrnchshn.finance;

import com.hrnchshn.finance.service.currencies.dto.CurrencyModel;
import com.hrnchshn.finance.service.currencies.impl.BankUaCurrencyProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CompletableFuture;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FinanceApplicationTests {

	@Test
	public void completableFeature() throws Exception{
		CompletableFuture<Integer> noteTask = CompletableFuture.completedFuture(43);
		System.out.println(noteTask.get());
	}

	@Test
	public void callback() throws Exception{
		CompletableFuture<CurrencyModel> noteTask =
				CompletableFuture.supplyAsync(()-> new BankUaCurrencyProvider().getCurrency());

		CompletableFuture<String> usdValue = noteTask.thenApply(currencyModel -> {
			System.out.println("This is callback");
			System.out.println(currencyModel);
			return currencyModel.getUsdValueBuy();
		});
	}
}

