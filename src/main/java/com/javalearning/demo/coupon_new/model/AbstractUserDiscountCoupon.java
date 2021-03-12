package com.javalearning.demo.coupon_new.model;

/**
 * @author lhh
 * @date 2021/3/12
 */
public abstract class AbstractUserDiscountCoupon implements UserDiscountCoupon {

    private UserCoupon userCoupon;

    public AbstractUserDiscountCoupon(UserCoupon userCoupon){
        this.userCoupon = userCoupon;
    }

    @Override
    public UserCoupon userCoupon() {
        return userCoupon;
    }

    @Override
    public <T extends DiscountResult<T>> T previewFor(DiscountTarget<T> target) {
        return null;
    }

    @Override
    public <T extends DiscountResult<T>> T applyTo(DiscountTarget<T> target) {
        int amtDiscount = calacAmtDiscountFor(target);
        if (amtDiscount > 0){
            userCoupon.setState(2);
            userCoupon.setAmtUsed(userCoupon.getAmtUsed() + amtDiscount);
        }

        return target.appliedCallback(amtDiscount);
    }

    @Override
    public Integer companyId() {
        return userCoupon.getCompanyId();
    }

    @Override
    public Integer tplId() {
        return userCoupon.getCouponId();
    }

    @Override
    public String name() {
        return userCoupon.getName() != null ? userCoupon.getName() : userCoupon.getCoupon().getCouponName();
    }

    @Override
    public String targetType() {
        return userCoupon.getTargetType() != null ? userCoupon.getTargetType() : "goods";
    }

    @Override
    public Integer state() {
        return userCoupon.getState();
    }

    @Override
    public boolean available() {
        return state() == 0;
    }

    @Override
    public boolean availableFor(DiscountTarget target) {
        return available() && targetType().equals(target.type());
    }

    @Override
    public int calacAmtDiscountFor(DiscountTarget target) {
        if (!isOverThreshold(target)){
            return 0;
        }

        return discountCalculator(target);
    }

    protected abstract int discountCalculator(DiscountTarget target);

    private boolean isOverThreshold(DiscountTarget target) {
        Integer amtThreshold = getAmtThreshold();

        if (amtThreshold == null || amtThreshold < 0){
            return false;
        }

        return target.amtForThreshold() >= amtThreshold;
    }

    private Integer getAmtThreshold() {

        Integer amtThreshold = userCoupon.getAmtThreshold();
        if (amtThreshold != null && amtThreshold >= 0) {
            return amtThreshold;
        }

        Coupon coupon = this.userCoupon.getCoupon();
        if (coupon == null){
            return null;
        }

        String couponLimitType = coupon.getCouponLimitType();
        if ("unlimited".equals(couponLimitType)) {
            return 0;
        }

        Integer amtCouponLimit = coupon.getAmtCouponLimit();
        if (amtCouponLimit == null || amtCouponLimit < 0){
            return null;
        }else {
            return amtCouponLimit;
        }
    }

    @Override
    public Integer amtAvailable() {
        return 0;
    }

    @Override
    public CouponDescription getDescription() {
        CouponDescription couponDescription = new CouponDescription();
        couponDescription.setType(targetType());
        couponDescription.setTypeName(typeNam());

        Integer amtThreshold = getAmtThreshold();
        if (amtThreshold == null || amtThreshold == 0){
            couponDescription.setThreshold("无使用门槛");
            return couponDescription;
        }

        String str;
        if (amtThreshold % 100 == 0){
            str = String.format("满 %d 元可用", amtThreshold / 100);
        }else {
            str = String.format("满 %.2f 元可用", amtThreshold / 100f);
        }
        couponDescription.setThreshold(str);
        return couponDescription;
    }

    private String typeNam() {
        String targetType = targetType();
        if ("goods".equals(targetType)) {
            return "商品券";
        }else if ("logistics".equals(targetType)){
            return "运费券";
        }else {
            return "优惠券";
        }
    }
}
