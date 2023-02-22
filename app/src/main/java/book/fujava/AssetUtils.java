package book.fujava;

import java.util.List;
import java.util.function.Predicate;

public class AssetUtils {
  public static int totalAssetValues(final List<Asset> assets){
    return assets.stream()
    .mapToInt(Asset::getValue)
    .sum();
  }

  public static int totalBondValues(final List<Asset> assets){
    return assets.stream()
            .mapToInt(asset -> asset.getType() == Asset.AssetType.BOND ? asset.getValue() : 0)
            .sum();
  }

  public static int totalAssetValues2(final List<Asset> assets,
                                      final Predicate<Asset> assertSelector){
    return assets.stream()
            .filter(assertSelector)
            .mapToInt(Asset::getValue)
            .sum();
  }
}