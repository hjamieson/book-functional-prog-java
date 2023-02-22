package book.fujava;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssetTest {

    final List<Asset> assets = Arrays.asList(
            new Asset(Asset.AssetType.BOND, 1000),
            new Asset(Asset.AssetType.BOND, 2000),
            new Asset(Asset.AssetType.STOCK, 3000),
            new Asset(Asset.AssetType.STOCK, 4000)
    );

    @Test
    void testSum() {
        assertEquals(10000, AssetUtils.totalAssetValues(assets), "sum should be 10k");
    }

    @Test
    void testSumBonds(){
        assertEquals(3000, AssetUtils.totalBondValues(assets), "should be 3k");
    }

    @Test
    void testValues2(){
        assertEquals(AssetUtils.totalAssetValues(assets),
                AssetUtils.totalAssetValues2(assets, asset -> true));
        assertEquals(AssetUtils.totalBondValues(assets),
                AssetUtils.totalAssetValues2(assets, asset -> asset.getType() == Asset.AssetType.BOND));
    }
}
