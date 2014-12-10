package fr.supelec.cs.searchapis;

import java.util.Iterator;

import net.billylieurance.azuresearch.AbstractAzureSearchQuery.AZURESEARCH_FORMAT;
import net.billylieurance.azuresearch.AzureSearchResultSet;
import net.billylieurance.azuresearch.AzureSearchWebQuery;
import net.billylieurance.azuresearch.AzureSearchWebResult;

public class BingSearch {

	// Update your Account ID - https://datamarket.azure.com/account.
	private static final String ACCOUNT_KEY = "tPCXwa0T4+aJE704J03C0O175sqIHz8sFIIxVdVPvX8";

	public void search(String searchParam) {
		AzureSearchWebQuery aq = new AzureSearchWebQuery();

		aq.setAppid(ACCOUNT_KEY);

		aq.setFormat(AZURESEARCH_FORMAT.XML);

		// searchParam is the field containing the keyword to be searched.
		aq.setQuery(searchParam);

		System.out.println("Before Query");
		aq.doQuery();
		System.out.println("After Query");
		AzureSearchResultSet<AzureSearchWebResult> azureSearchResultSet = aq
				.getQueryResult();

		for (Iterator<AzureSearchWebResult> iterator = azureSearchResultSet
				.iterator(); iterator.hasNext();) {
			AzureSearchWebResult result = (AzureSearchWebResult) iterator
					.next();

			// Populate the data from result object in to your custom objects.

			System.out.println(result.getTitle());
			System.out.println(result.getUrl());
			System.out.println(result.getDisplayUrl());
			System.out.println(result.getDescription());

		}
	}

	public static void main(String[] args) {
		BingSearch bingSearch = new BingSearch();
		bingSearch.search("Keyboard");
	}

}
