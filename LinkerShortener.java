
		import java.util.HashMap;
		import java.util.Map;
		import java.util.Random;

		public class LinkerShortener {
		    private Map<String, String> shortToLongMap;
		    private Map<String, String> longToShortMap;
		    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		    private static final int SHORT_LINK_LENGTH = 6; // Length of the short link

		    public LinkerShortener() {
		        this.shortToLongMap = new HashMap<>();
		        this.longToShortMap = new HashMap<>();
		    }

		    public String shorten(String longUrl) {
		        if (longToShortMap.containsKey(longUrl)) {
		            return longToShortMap.get(longUrl);
		        }
		        String shortUrl = generateShortUrl();
		        shortToLongMap.put(shortUrl, longUrl);
		        longToShortMap.put(longUrl, shortUrl);
		        return shortUrl;
		    }

		    public String expand(String shortUrl) {
		        return shortToLongMap.getOrDefault(shortUrl, "Short URL not found");
		    }

		    private String generateShortUrl() {
		        StringBuilder shortUrl = new StringBuilder();
		        Random random = new Random();
		        for (int i = 0; i < SHORT_LINK_LENGTH; i++) {
		            int randomIndex = random.nextInt(CHARACTERS.length());
		            shortUrl.append(CHARACTERS.charAt(randomIndex));
		        }
		        return shortUrl.toString();
		    }

		    public static void main(String[] args) {
		        LinkerShortener linkShortener = new LinkerShortener();
		        String longUrl = "https://www.example.com";
		        String shortUrl = linkShortener.shorten(longUrl);
		        System.out.println("Shortened URL: " + shortUrl);
		        String expandedUrl = linkShortener.expand(shortUrl);
		        System.out.println("Expanded URL: " + expandedUrl);
		    }
		}

	

