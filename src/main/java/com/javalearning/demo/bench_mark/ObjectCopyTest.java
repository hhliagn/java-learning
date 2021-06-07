package com.javalearning.demo.bench_mark;

/**
 * @author lhh
 * @date 2021/4/16
 */
//@BenchmarkMode(Mode.AverageTime)
//@Warmup(iterations = 5)
//@Measurement(iterations = 5, time = 5, timeUnit = TimeUnit.SECONDS)
//@Threads(1)
//@Fork(1)
//@OutputTimeUnit(TimeUnit.MILLISECONDS)
//public class ObjectCopyTest {
//
//    //输入数据
//    static List<PriceDto> data = buildObjectData();
//
//    @Benchmark
//    public void testBeanUtils() {
//        BeanUtils.copyListProperties(data, Price.class);
//    }
//
//    @Benchmark
//    public void testBeanCopierUtil() {
//        BeanCopierUtil.copyPropertiesOfList(data, Price.class);
//    }
//
//    @Benchmark
//    public void testMapstruct() {
//        PriceMapper mapper = Mappers.getMapper(PriceMapper.class);
//        List<Price> hash = mapper.dtoToEntity(data);
//    }
//
//    public static void main(String[] args) throws RunnerException {
//        Options opt = new OptionsBuilder()
//                .include(ObjectCopyTest.class.getSimpleName())
//                .build();
//        new Runner(opt).run();
//    }
//
//    /**
//     * 读取json文件，返回json串 初始化数据
//     *
//     * @return
//     */
//    private static List<PriceDto> buildObjectData() {
//
//        List<PriceDto> subTrades = null;
//        File jsonFile = new File("/Users/wangyunjing/Work/YXfile/gg.json");
//        try {
//            FileReader fileReader = new FileReader(jsonFile);
//            Reader reader = null;
//            reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
//            int ch = 0;
//            StringBuffer sb = new StringBuffer();
//            while ((ch = reader.read()) != -1) {
//                sb.append((char) ch);
//            }
//            fileReader.close();
//            reader.close();
//            String jsonStr = sb.toString();
//            subTrades = JSON.parseArray(jsonStr, PriceDto.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return subTrades;
//    }
//}

