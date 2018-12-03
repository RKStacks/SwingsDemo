
package com.android.market;

import com.gc.android.market.api.MarketSession;
import com.gc.android.market.api.MarketSession.Callback;
import com.gc.android.market.api.model.Market.AppsRequest;
import com.gc.android.market.api.model.Market.AppsResponse;
import com.gc.android.market.api.model.Market.RequestContext.Builder;
import com.gc.android.market.api.model.Market.ResponseContext;

public class AndroidMarketAPi {

	public static void main(String[] args) {
	}

	@SuppressWarnings("unchecked")
	private static void sessionTest(String email, String password, String myAndroidId) {
		try
		{
			MarketSession session = new MarketSession();
			session.login(email, password);
			Builder context = session.getContext();
			context.setAndroidId(myAndroidId);

			String query = "maps";
			AppsRequest appsRequest = AppsRequest.newBuilder().setQuery(query).setStartIndex(0).setEntriesCount(10).setWithExtendedInfo(true).build();

			session.append(appsRequest, new Callback() {

				@Override
				public void onResult(ResponseContext context, Object object) {
					AppsResponse response = (AppsResponse) object;
					// Your code here // 
					String creator = response.getApp(0).getCreator();
					System.out.println("Response : " + creator);
				}
			});
			session.flush();
		}
		catch (Exception e)
		{
			System.err.println("Error : " + e);
		}
	}
}
