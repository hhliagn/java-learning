package com.javalearning.demo.bench_mark;

/**
 * @author lhh
 * @date 2021/4/16
 */
//@BenchmarkMode(Mode.AverageTime)
//@Warmup(iterations = 3)
//@Measurement(iterations = 3, time = 5, timeUnit = TimeUnit.SECONDS)
//@Threads(1)
//@Fork(1)
//@OutputTimeUnit(TimeUnit.NANOSECONDS)
//public class BatchObjectCopyTest {
//
//    private final static int lim = 1000;
//
//    //输入数据
//    static List<PriceDto> data = buildObjectData();
//
//    @Benchmark
//    public void testBeanCopierUtil() {
//        BeanCopierUtil.copyPropertiesOfList(data, Price.class);
//    }
//
//    @Benchmark
//    public void testMapstruct() {
//        PriceMapper mapper = Mappers.getMapper(PriceMapper.class);
//        List<Price> list = mapper.dtoToEntity(data);
//    }
//
//    public static void main(String[] args) throws RunnerException {
//        Options opt = new OptionsBuilder()
//                .include(ObjectCopyTest.class.getSimpleName())
//                .build();
//        new Runner(opt).run();
//    }
//
//    @Benchmark
//    public void testBeanUtils() {
//        BeanUtils.copyListProperties(data, Price.class);
//    }
//
//    /**
//     * 参考写法 不够严谨
//     */
//    @Benchmark
//    public void testBatchBeanUtils() {
//        List<PriceDto> data = ObjectCopyTest.buildObjectData();
//        List<Price> all = new ArrayList<>();
//        List<PriceDto> Temp = new ArrayList<>();
//        int max = data.size();
//        int point = 0;
//        int move = lim;
//        boolean loop = false;
//        while (data.size() > 0) {
//            if (data.size() > lim && !loop) {
//                if (move < max) {
//                    List<PriceDto> batch = data.subList(point, move);
//                    List<Price> part = BeanUtils.copyListProperties(batch, Price.class);
//                    all.addAll(part);
//                    Temp.addAll(batch);
//
//                    point = move;
//                    move += lim;
//                } else {
//                    List<PriceDto> batch = data.subList(point, max);
//                    List<Price> part = BeanUtils.copyListProperties(batch, Price.class);
//                    all.addAll(part);
//                    loop = true;
//                    Temp.addAll(batch);
//                }
//            }
//            if (loop) {
//                data.removeAll(Temp);
//            }
//        }
//    }
//
//    /**
//     * 参考写法 不够严谨
//     */
//    @Benchmark
//    public void testBatchMapstruct() {
//        List<PriceDto> data = ObjectCopyTest.buildObjectData();
//        List<Price> all = new ArrayList<>();
//        List<PriceDto> Temp = new ArrayList<>();
//        int max = data.size();
//        int point = 0;
//        int move = lim;
//        boolean loop = false;
//        while (data.size() > 0) {
//            if (data.size() > lim && !loop) {
//                if (move < max) {
//                    List<PriceDto> batch = data.subList(point, move);
//                    PriceMapper mapper = Mappers.getMapper(PriceMapper.class);
//                    List<Price> part = mapper.dtoToEntity(data);
//                    all.addAll(part);
//                    Temp.addAll(batch);
//
//                    point = move;
//                    move += lim;
//                } else {
//                    List<PriceDto> batch = data.subList(point, max);
//                    PriceMapper mapper = Mappers.getMapper(PriceMapper.class);
//                    List<Price> part = mapper.dtoToEntity(data);
//                    all.addAll(part);
//                    all.addAll(part);
//                    loop = true;
//                    Temp.addAll(batch);
//                }
//            }
//            if (loop) {
//                data.removeAll(Temp);
//            }
//        }
//    }
//
//    /**
//     * 参考写法 不够严谨
//     */
//    @Benchmark
//    public void testBatchBeanCopierUtil() {
//        List<PriceDto> data = ObjectCopyTest.buildObjectData();
//        List<Price> all = new ArrayList<>();
//        List<PriceDto> Temp = new ArrayList<>();
//        int max = data.size();
//        int point = 0;
//        int move = lim;
//        boolean loop = false;
//        while (data.size() > 0) {
//            if (data.size() > lim && !loop) {
//                if (move < max) {
//                    List<PriceDto> batch = data.subList(point, move);
//                    List<Price> part = BeanCopierUtil.copyPropertiesOfList(batch, Price.class);
//                    all.addAll(part);
//                    Temp.addAll(batch);
//
//                    point = move;
//                    move += lim;
//                } else {
//                    List<PriceDto> batch = data.subList(point, max);
//                    List<Price> part = BeanCopierUtil.copyPropertiesOfList(data, Price.class);
//                    all.addAll(part);
//                    loop = true;
//                    Temp.addAll(batch);
//                }
//            }
//            if (loop) {
//                data.removeAll(Temp);
//            }
//        }
//    }
//
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

