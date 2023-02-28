package co.jp.practise.domian.design.u46_build;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

/**
 * 建造者模式
 */
public class ResourcePoolConfig {

    private final String name;
    private final int maxTotal;
    private final int maxIdle;
    private final int minIdle;

    ResourcePoolConfig(Builder builder) {
        this.name = builder.name;
        this.maxIdle = builder.maxIdle;
        this.maxTotal = builder.maxTotal;
        this.minIdle = builder.minIdle;
    }

    public static void main(String[] args) {
        ResourcePoolConfig config = new ResourcePoolConfig.Builder()
                .name("dbconnectionpool")
                .maxTotal(16)
                .maxIdle(10)
                .minIdle(8)
                .build();
        Gson gson = new Gson();
        System.out.println(gson.toJson(config));
    }

    public static class Builder {
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;
        private String name;
        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;

        private ResourcePoolConfig build() {
            Assert.isTrue(StringUtils.isNotBlank(name));
            Assert.isTrue(maxIdle <= maxTotal);
            Assert.isTrue(minIdle <= maxTotal && minIdle < maxIdle);
            return new ResourcePoolConfig(this);
        }

        public Builder name(String name) {
            Assert.isTrue(StringUtils.isNotBlank(name));
            this.name = name;
            return this;
        }

        public Builder maxTotal(int maxTotal) {
            Assert.isTrue(maxTotal >= 0);
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder maxIdle(int maxIdle) {
            Assert.isTrue(maxIdle >= 0);
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder minIdle(int minIdle) {
            Assert.isTrue(minIdle >= 0);
            this.minIdle = minIdle;
            return this;
        }
    }
}
