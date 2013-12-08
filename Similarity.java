import java.util.ArrayList;


public class Similarity {
	private static int minimum( int x, int y, int z ) {
		if ( x <= y && x <= z ) {
			return x;
		}
		else if ( y <= x && y <= z ) {
			return y;
		}
		else
			return z;
	}

	static Double getSimilarity( String s1, String s2 ) {
		int s1Len = s1.length(), s2Len = s2.length();
		
		Double maxVal = -1.0;
		if( s1Len < s2Len ) {
			for( int i = s1Len; i <= s2Len; ++i ) {
				int distance = getDistance( s1, s2.substring(0, i ) );
				double invertedDistance = (1000.0-distance)/1000.0;
				double weight = ((double) i) / ((double) s2Len);
				double similarity = weight * invertedDistance;
				if ( similarity == 1.0 ) { 
					return 1.0;	// Perfect match found, end early
				}
				if ( distance > 0 ) {
					similarity /= 4;	// Preference is given to strings/sub-strings that match 100%
				}
				if ( similarity > maxVal ) {
					maxVal = similarity; 
				}
			}
			for( int i = s1Len; i < s2Len; ++i ) {
				int distance = getDistance( s1, s2.substring(s2Len-i, s2Len ) );
				double invertedDistance = (1000.0-distance)/1000.0;
				double weight = ((double) (s2Len-i)) / ((double) s2Len);
				double similarity = weight * invertedDistance;
				if ( similarity == 1.0 ) { 
					return 1.0;	// Perfect match found, end early
				}
				if ( distance > 0 ) {
					similarity /= 4;	// Preference is given to strings/sub-strings that match 100%
				}
				if ( similarity > maxVal ) {
					maxVal = similarity; 
				}
			}
			for( int i = 1; i < (s2Len-s1Len); ++i ) {
				int distance = getDistance( s1, s2.substring(i, i + s1Len ) );
				double invertedDistance = (1000.0-distance)/1000.0;
				double weight = ((double) s1Len) / ((double) s2Len);
				double similarity = weight * invertedDistance;
				if ( similarity == 1.0 ) { 
					return 1.0;	// Perfect match found, end early
				}
				if ( distance > 0 ) {
					similarity /= 4;	// Preference is given to strings/sub-strings that match 100%
				}
				if ( similarity > maxVal ) {
					maxVal = similarity; 
				}
			}
		}
		else {
			for( int i = s2Len; i <= s1Len; ++i ) {
				int distance = getDistance( s2, s1.substring(0, i ) );
				double invertedDistance = (1000.0-distance)/1000.0;
				double weight = ((double) i) / ((double) s1Len);
				double similarity = weight * invertedDistance;
				if ( similarity == 1.0 ) { 
					return 1.0;	// Perfect match found, end early
				}
				if ( distance > 0 ) {
					similarity /= 4;	// Preference is given to strings/sub-strings that match 100%
				}
				if ( similarity > maxVal ) {
					maxVal = similarity;
				}
			}
			for( int i = s2Len; i < s1Len; ++i ) {
				int distance = getDistance( s2, s1.substring(s1Len-i, s1Len ) );
				double invertedDistance = (1000.0-distance)/1000.0;
				double weight = ((double) (s1Len-i)) / ((double) s1Len);
				double similarity = weight * invertedDistance;
				if ( similarity == 1.0 ) { 
					return 1.0;	// Perfect match found, end early
				}
				if ( distance > 0 ) {
					similarity /= 4;	// Preference is given to strings/sub-strings that match 100%
				}
				if ( similarity > maxVal ) {
					maxVal = similarity; 
				}
			}
			for( int i = 1; i < (s1Len-s2Len); ++i ) {
				int distance = getDistance( s2, s1.substring(i, i + s2Len ) );
				double invertedDistance = (1000.0-distance)/1000.0;
				double weight = ((double) s2Len) / ((double) s1Len);
				double similarity = weight * invertedDistance;
				if ( similarity == 1.0 ) { 
					return 1.0;	// Perfect match found, end early
				}
				if ( distance > 0 ) {
					similarity /= 4;	// Preference is given to strings/sub-strings that match 100%
				}
				if ( similarity > maxVal ) {
					maxVal = similarity; 
				}
			}
		}
		
		return maxVal;
	}
	
	static int getDistance(String str1,String str2) {
        int[][] distance = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++)
        	distance[i][0] = i;
        for (int j = 1; j <= str2.length(); j++)
        	distance[0][j] = j;

        for (int i = 1; i <= str1.length(); i++)
        	for (int j = 1; j <= str2.length(); j++)
        		distance[i][j] = minimum(
                distance[i - 1][j] + 1,
                distance[i][j - 1] + 1,
                distance[i - 1][j - 1]+ ((str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0 : 1));

        return distance[str1.length()][str2.length()];    
	}
	
	static int advancedGetDistance(String str1, String str2) {
        int[][] distance = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++)
        	distance[i][0] = i;
        for (int j = 1; j <= str2.length(); j++)
        	distance[0][j] = j;

        for (int i = 1; i <= str1.length(); i++)
        	for (int j = 1; j <= str2.length(); j++)
        		distance[i][j] = minimum(
                distance[i - 1][j] + 1,
                distance[i][j - 1] + 1,
                distance[i - 1][j - 1]+ ((str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0 : 1));

        return distance[str1.length()][str2.length()];    
	}

}
