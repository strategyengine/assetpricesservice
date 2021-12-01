package com.reticulogic.flare.assetpriceservice.coinmarketecap;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@EqualsAndHashCode
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class CoinMarketCapRates {

	/**
	 * {"status":{"timestamp":"2021-12-01T12:28:45.332Z","error_code":0,"error_message":null,"elapsed":41,"credit_count":2,"notice":null,"total_count":7857},
	 * "data":[
	 *     {"id":1,"name":"Bitcoin","symbol":"BTC","slug":"bitcoin","num_market_pairs":8312,"date_added":"2013-04-28T00:00:00.000Z",
	 *        "tags":["mineable","pow","sha-256","store-of-value","state-channel","coinbase-ventures-portfolio","three-arrows-capital-portfolio","polychain-capital-portfolio","binance-labs-portfolio","blockchain-capital-portfolio","boostvc-portfolio","cms-holdings-portfolio","dcg-portfolio","dragonfly-capital-portfolio","electric-capital-portfolio","fabric-ventures-portfolio","framework-ventures-portfolio","galaxy-digital-portfolio","huobi-capital-portfolio","alameda-research-portfolio","a16z-portfolio","1confirmation-portfolio","winklevoss-capital-portfolio","usv-portfolio","placeholder-ventures-portfolio","pantera-capital-portfolio","multicoin-capital-portfolio","paradigm-portfolio"],"max_supply":21000000,"circulating_supply":18888018,"total_supply":18888018,"platform":null,"cmc_rank":1,"last_updated":"2021-12-01T12:26:08.000Z",
	 *        "quote":{"USD":{"price":57289.98617341837,"volume_24h":36307442533.43664,"volume_change_24h":3.7154,"percent_change_1h":0.65934399,"percent_change_24h":-1.29534984,"percent_change_7d":1.26111497,"percent_change_30d":-7.44986673,"percent_change_60d":19.97119824,"percent_change_90d":14.53398895,"market_cap":1082094290063.2773,"market_cap_dominance":40.8403,"fully_diluted_market_cap":1203089709641.79,"last_updated":"2021-12-01T12:26:08.000Z"}}},
	 *     {"id":1027,"name":"Ethereum","symbol":"ETH","slug":"ethereum","num_market_pairs":4671,"date_added":"2015-08-07T00:00:00.000Z","tags":["mineable","pow","smart-contracts","ethereum-ecosystem","binance-smart-chain","coinbase-ventures-portfolio","three-arrows-capital-portfolio","polychain-capital-portfolio","binance-labs-portfolio","blockchain-capital-portfolio","boostvc-portfolio","cms-holdings-portfolio","dcg-portfolio","dragonfly-capital-portfolio","electric-capital-portfolio","fabric-ventures-portfolio","framework-ventures-portfolio","hashkey-capital-portfolio","kinetic-capital-portfolio","huobi-capital-portfolio","alameda-research-portfolio","a16z-portfolio","1confirmation-portfolio","winklevoss-capital-portfolio","usv-portfolio","placeholder-ventures-portfolio","pantera-capital-portfolio","multicoin-capital-portfolio","paradigm-portfolio"],"max_supply":null,"circulating_supply":118562740.999,"total_supply":118562740.999,"platform":null,"cmc_rank":2,"last_updated":"2021-12-01T12:26:07.000Z","quote":{"USD":{"price":4704.798995418166,"volume_24h":29144560442.39812,"volume_change_24h":25.4975,"percent_change_1h":0.01287171,"percent_change_24h":1.98086033,"percent_change_7d":9.66950878,"percent_change_30d":8.08794337,"percent_change_60d":42.61160047,"percent_change_90d":24.34590563,"market_cap":557813864746.1194,"market_cap_dominance":21.0355,"fully_diluted_market_cap":557813864746.12,"last_updated":"2021-12-01T12:26:07.000Z"}}},{"id":1839,"name":"Binance Coin","symbol":"BNB","slug":"binance-coin","num_market_pairs":558,"date_added":"2017-07-25T00:00:00.000Z","tags":["marketplace","centralized-exchange","payments","smart-contracts","binance-smart-chain","alameda-research-portfolio","multicoin-capital-portfolio"],"max_supply":166801148,"circulating_supply":166801148,"total_supply":166801148,"platform":null,"cmc_rank":3,"last_updated":"2021-12-01T12:26:39.000Z","quote":{"USD":{"price":642.6985079978421,"volume_24h":3009500319.3527503,"volume_change_24h":15.9675,"percent_change_1h":0.55836706,"percent_change_24h":2.47492622,"percent_change_7d":8.77135788,"percent_change_30d":20.55316409,"percent_change_60d":51.34462701,"percent_change_90d":30.53242309,"market_cap":107202848951.92723,"market_cap_dominance":4.0427,"fully_diluted_market_cap":107202848951.93,"last_updated":"2021-12-01T12:26:39.000Z"}}},{"id":825,"name":"Tether","symbol":"USDT","slug":"tether","num_market_pairs":20119,"date_added":"2015-02-25T00:00:00.000Z","tags":["payments","stablecoin","asset-backed-stablecoin","binance-smart-chain","avalanche-ecosystem","solana-ecosystem"],"max_supply":null,"circulating_supply":73578322706.64124,"total_supply":76351995265.76913,"platform":{"id":1027,"name":"Ethereum","symbol":"ETH","slug":"ethereum","token_address":"0xdac17f958d2ee523a2206206994597c13d831ec7"},"cmc_rank":4,"last_updated":"2021-12-01T12:26:37.000Z","quote":{"USD":{"price":1.0006725100472635,"volume_24h":84716878269.32445,"volume_change_24h":3.9474,"percent_change_1h":-0.05063584,"percent_change_24h":-0.04100741,"percent_change_7d":0.02299169,"percent_change_30d":0.00035499,"percent_change_60d":0.04493691,"percent_change_90d":0.02539478,"market_cap":73627804867.92226,"market_cap_dominance":2.7766,"fully_diluted_market_cap":76403342749.71,"last_updated":"2021-12-01T12:26:37.000Z"}}},{"id":5426,"name":"Solana","symbol":"SOL","slug":"solana","num_market_pairs":190,"date_added":"2020-04-10T00:00:00.000Z","tags":["pos","platform","solana-ecosystem","cms-holdings-portfolio","kinetic-capital-portfolio","alameda-research-portfolio","multicoin-capital-portfolio","k300-ventures-portfolio"],"max_supply":null,"circulating_supply":305862835.8774686,"total_supply":510205979.7185949,"platform":null,"cmc_rank":5,"last_updated":"2021-12-01T12:26:18.000Z","quote":{"USD":{"price":222.31853971080588,"volume_24h":3390009529.2074842,"volume_change_24h":59.2624,"percent_change_1h":0.00275017,"percent_change_24h":6.74138905,"percent_change_7d":3.67799949,"percent_change_30d":7.92780214,"percent_change_60d":39.65661268,"percent_change_90d":93.0327791,"market_cap":67998979024.0847,"market_cap_dominance":2.5643,"fully_diluted_market_cap":113428248362.76,"last_updated":"2021-12-01T12:26:18.000Z"}}},{"id":2010,"name":"Cardano","symbol":"ADA","slug":"cardano","num_market_pairs":298,"date_added":"2017-10-01T00:00:00.000Z","tags":["mineable","dpos","pos","platform","research","smart-contracts","staking","binance-smart-chain","cardano-ecosystem"],"max_supply":45000000000,"circulating_supply":33313246914.729,"total_supply":33719282563.077,"platform":null,"cmc_rank":6,"last_updated":"2021-12-01T12:26:40.000Z","quote":{"USD":{"price":1.5965411465301966,"volume_24h":1781427242.8446531,"volume_change_24h":-5.0385,"percent_change_1h":0.79847895,"percent_change_24h":-0.46996977,"percent_change_7d":-4.82216646,"percent_change_30d":-19.2150327,"percent_change_60d":-28.28053993,"percent_change_90d":-47.63427104,"market_cap":53185969423.88497,"market_cap_dominance":2.0057,"fully_diluted_market_cap":71844351593.86,"last_updated":"2021-12-01T12:26:40.000Z"}}},{"id":52,"name":"XRP","symbol":"XRP","slug":"xrp","num_market_pairs":615,"date_added":"2013-08-04T00:00:00.000Z","tags":["medium-of-exchange","enterprise-solutions","binance-chain","arrington-xrp-capital-portfolio","galaxy-digital-portfolio","a16z-portfolio","pantera-capital-portfolio"],"max_supply":100000000000,"circulating_supply":47158974920,"total_supply":99990145360,"platform":null,"cmc_rank":7,"last_updated":"2021-12-01T12:26:07.000Z","quote":{"USD":{"price":1.006373616757293,"volume_24h":2731426093.208632,"volume_change_24h":-7.798,"percent_change_1h":0.60069599,"percent_change_24h":-0.10063343,"percent_change_7d":-2.78445325,"percent_change_30d":-7.81747405,"percent_change_60d":-2.33720866,"percent_change_90d":-21.83577261,"market_cap":47459548152.80687,"market_cap_dominance":1.7898,"fully_diluted_market_cap":100637361675.73,"last_updated":"2021-12-01T12:26:07.000Z"}}},{"id":3408,"name":"USD Coin","symbol":"USDC","slug":"usd-coin","num_market_pairs":1683,"date_added":"2018-10-08T00:00:00.000Z","tags":["medium-of-exchange","stablecoin","asset-backed-stablecoin","binance-smart-chain","fantom-ecosystem"],"max_supply":null,"circulating_supply":38692633571.082664,"total_supply":38692633571.082664,"platform":{"id":1027,"name":"Ethereum","symbol":"ETH","slug":"ethereum","token_address":"0xa0b86991c6218b36c1d19d4a2e9eb0ce3606eb48"},"cmc_rank":8,"last_updated":"2021-12-01T12:26:29.000Z","quote":{"USD":{"price":1.0000397795200355,"volume_24h":5330796778.801618,"volume_change_24h":14.0441,"percent_change_1h":-0.03442477,"percent_change_24h":-0.16215649,"percent_change_7d":-0.01863171,"percent_change_30d":0.00687805,"percent_change_60d":0.01539195,"percent_change_90d":0.01165151,"market_cap":38694172745.47504,"market_cap_dominance":1.4592,"fully_diluted_market_cap":38694172745.48,"last_updated":"2021-12-01T12:26:29.000Z"}}},{"id":6636,"name":"Polkadot","symbol":"DOT","slug":"polkadot-new","num_market_pairs":248,"date_added":"2020-08-19T00:00:00.000Z","tags":["substrate","polkadot","binance-chain","binance-smart-chain","polkadot-ecosystem","three-arrows-capital-portfolio","polychain-capital-portfolio","arrington-xrp-capital-portfolio","blockchain-capital-portfolio","boostvc-portfolio","cms-holdings-portfolio","coinfund-portfolio","fabric-ventures-portfolio","fenbushi-capital-portfolio","hashkey-capital-portfolio","kinetic-capital-portfolio","1confirmation-portfolio","placeholder-ventures-portfolio","pantera-capital-portfolio","exnetwork-capital-portfolio","web3"],"max_supply":null,"circulating_supply":987579314.957085,"total_supply":1103303471.382273,"platform":null,"cmc_rank":9,"last_updated":"2021-12-01T12:26:28.000Z","quote":{"USD":{"price":37.595197587872654,"volume_24h":1516187212.3271728,"volume_change_24h":19.1207,"percent_change_1h":0.84593456,"percent_change_24h":1.57195548,"percent_change_7d":-4.41628497,"percent_change_30d":-16.8403713,"percent_change_60d":16.79580889,"percent_change_90d":16.14238005,"market_cap":37128239479.50753,"market_cap_dominance":1.4013,"fully_diluted_market_cap":41478912006,"last_updated":"2021-12-01T12:26:28.000Z"}}},{"id":74,"name":"Dogecoin","symbol":"DOGE","slug":"dogecoin","num_market_pairs":405,"date_added":"2013-12-15T00:00:00.000Z","tags":["mineable","pow","scrypt","medium-of-exchange","memes","payments","binance-smart-chain","doggone-doggerel"],"max_supply":null,"circulating_supp...
	 */
	
	private List<CoinMarketCapData> data;

	
}

/*
example response 
{
"success": true,
"terms": "https:\/\/coinlayer.com\/terms",
"privacy": "https:\/\/coinlayer.com\/privacy",
"timestamp": 1629119646,
"target": "USD",
"rates": {
	"ABC": 59.99,
	"ACP": 0.014931,
	"ACT": 0.012301,
	"ACT*": 0.017178,
	"ADA": 2.154697,
	"ADCN": 0.00013,
	"ADL": 0.01515,
	"ADX": 0.512371,
	"ADZ": 0.0023,
	"AE": 0.1449
}
}
*/