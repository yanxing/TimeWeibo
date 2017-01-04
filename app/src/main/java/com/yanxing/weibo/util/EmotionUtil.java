package com.yanxing.weibo.util;

import android.support.v4.util.ArrayMap;

import com.yanxing.weibo.R;

/**
 * 微博表情
 * Created by lishuangxiang on 2016/12/26.
 */
public class EmotionUtil {

    public static ArrayMap<String, Integer> map;

    static {
        map = new ArrayMap<>();
        map.put("[笑哈哈]", R.mipmap.lxh_xiaohaha);
        map.put("[好爱哦]", R.mipmap.lxh_haoaio);
        map.put("[噢耶]", R.mipmap.lxh_oye);
        map.put("[偷乐]", R.mipmap.lxh_toule);
        map.put("[泪流满面]", R.mipmap.lxh_leiliumanmian);
        map.put("[巨汗]", R.mipmap.lxh_juhan);
        map.put("[抠鼻屎]", R.mipmap.lxh_koubishi);
        map.put("[求关注]", R.mipmap.lxh_qiuguanzhu);
        map.put("[好喜欢]", R.mipmap.lxh_haoxihuan);
        map.put("[崩溃]", R.mipmap.lxh_bengkui);
        map.put("[好囧]", R.mipmap.lxh_haojiong);
        map.put("[震惊]", R.mipmap.lxh_zhenjing);
        map.put("[别烦我]", R.mipmap.lxh_biefanwo);
        map.put("[不好意思]", R.mipmap.lxh_buhaoyisi);
        map.put("[羞嗒嗒]", R.mipmap.lxh_xiudada);
        map.put("[得意地笑]", R.mipmap.lxh_deyidexiao);
        map.put("[纠结]", R.mipmap.lxh_jiujie);
        map.put("[给劲]", R.mipmap.lxh_feijin);
        map.put("[悲催]", R.mipmap.lxh_beicui);
        map.put("[甩甩手]", R.mipmap.lxh_shuaishuaishou);
        map.put("[好棒]", R.mipmap.lxh_haobang);
        map.put("[瞧瞧]", R.mipmap.lxh_qiaoqiao);
        map.put("[不想上班]", R.mipmap.lxh_buxiangshangban);
        map.put("[困死了]", R.mipmap.lxh_kunsile);
        map.put("[许愿]", R.mipmap.lxh_xuyuan);
        map.put("[丘比特]", R.mipmap.lxh_qiubite);
        map.put("[有鸭梨]", R.mipmap.lxh_youyali);
        map.put("[想一想]", R.mipmap.lxh_xiangyixiang);
        map.put("[躁狂症]", R.mipmap.lxh_kuangzaozheng);
        map.put("[转发]", R.mipmap.lxh_zhuanfa);
        map.put("[互相膜拜]", R.mipmap.lxh_xianghumobai);
        map.put("[雷锋]", R.mipmap.lxh_leifeng);
        map.put("[杰克逊]", R.mipmap.lxh_jiekexun);
        map.put("[玫瑰]", R.mipmap.lxh_meigui);
        map.put("[hold住]", R.mipmap.lxh_holdzhu);
        map.put("[群体围观]", R.mipmap.lxh_quntiweiguan);
        map.put("[推荐]", R.mipmap.lxh_tuijian);
        map.put("[赞啊]", R.mipmap.lxh_zana);
        map.put("[被电]", R.mipmap.lxh_beidian);
        map.put("[霹雳]", R.mipmap.lxh_pili);
        map.put("[蜡烛]", R.mipmap.o_lazhu);
        map.put("[发红包]", R.mipmap.o_fahongbao);
        map.put("[汽车]", R.mipmap.o_qiche);
        map.put("[飞机]", R.mipmap.o_feiji);
        map.put("[自行车]", R.mipmap.o_zixingche);
        map.put("[礼物]", R.mipmap.o_liwu);
        map.put("[照相机]", R.mipmap.o_zhaoxiangji);
        map.put("[手机]", R.mipmap.o_shouji);
        map.put("[风扇]", R.mipmap.o_fengshan);
        map.put("[话筒]", R.mipmap.o_huatong);
        map.put("[钟]", R.mipmap.o_zhong);
        map.put("[足球]", R.mipmap.o_zuqiu);
        map.put("[电影]", R.mipmap.o_dianying);
        map.put("[音乐]", R.mipmap.o_yinyue);
        map.put("[实习]", R.mipmap.o_shixi);
        map.put("[鲜花]", R.mipmap.w_xianhua);
        map.put("[心]", R.mipmap.l_xin);
        map.put("[伤心]", R.mipmap.l_shangxin);
        map.put("[爱心传递]", R.mipmap.l_aixinchuandi);
        map.put("[互粉]", R.mipmap.f_hufen);
        map.put("[萌]", R.mipmap.f_meng);
        map.put("[囧]", R.mipmap.f_jiong);
        map.put("[织]", R.mipmap.f_zhi);
        map.put("[帅]", R.mipmap.f_shuai);
        map.put("[喜]", R.mipmap.f_xi);
        map.put("[围脖]", R.mipmap.o_weibo);
        map.put("[温暖帽子]", R.mipmap.o_wennuanmaozi);
        map.put("[手套]", R.mipmap.o_shoutao);
        map.put("[绿丝带]", R.mipmap.o_lvsidai);
        map.put("[红丝带]", R.mipmap.o_hongsidai);
        map.put("[蛋糕]", R.mipmap.o_dangao);
        map.put("[咖啡]", R.mipmap.o_kafei);
        map.put("[西瓜]", R.mipmap.o_xigua);
        map.put("[冰棍]", R.mipmap.o_bingun);
        map.put("[干杯]", R.mipmap.o_ganbei);
        map.put("[猪头]", R.mipmap.d_zhutou);
        map.put("[握手]", R.mipmap.h_woshou);
        map.put("[耶]", R.mipmap.h_ye);
        map.put("[good]", R.mipmap.h_good);
        map.put("[弱]", R.mipmap.h_ruo);
        map.put("[不要]", R.mipmap.h_buyao);
        map.put("[ok]", R.mipmap.h_ok);
        map.put("[赞]", R.mipmap.h_zan);
        map.put("[来]", R.mipmap.h_lai);
        map.put("[haha]", R.mipmap.h_haha);
        map.put("[拳头]", R.mipmap.h_quantou);
        map.put("[最差]", R.mipmap.h_zuicha);
        map.put("[月亮]", R.mipmap.w_yueliang);
        map.put("[太阳]", R.mipmap.w_taiyang);
        map.put("[微风]", R.mipmap.w_weifeng);
        map.put("[沙尘暴]", R.mipmap.w_shachenbao);
        map.put("[下雨]", R.mipmap.w_xiayu);
        map.put("[雪]", R.mipmap.w_xue);
        map.put("[雪人]", R.mipmap.w_xueren);
        map.put("[落叶]", R.mipmap.w_luoye);
        map.put("[左哼哼]", R.mipmap.d_zuohengheng);
        map.put("[嘘]", R.mipmap.d_xu);
        map.put("[委屈]", R.mipmap.d_weiqu);
        map.put("[吐]", R.mipmap.d_tu);
        map.put("[可怜]", R.mipmap.d_kelian);
        map.put("[打哈气]", R.mipmap.d_dahaqi);
        map.put("[做鬼脸]", R.mipmap.d_zuoguilian);
        map.put("[失望]", R.mipmap.d_shiwang);
        map.put("[顶]", R.mipmap.d_ding);
        map.put("[疑问]", R.mipmap.d_yiwen);
        map.put("[书呆子]", R.mipmap.d_shudaizi);
        map.put("[困]", R.mipmap.d_kun);
        map.put("[感冒]", R.mipmap.d_ganmao);
        map.put("[拜拜]", R.mipmap.d_baibai);
        map.put("[黑线]", R.mipmap.d_heixian);
        map.put("[阴险]", R.mipmap.d_yinxian);
        map.put("[愤怒]", R.mipmap.d_fennu);
        map.put("[男孩儿]", R.mipmap.d_nanhaier);
        map.put("[女孩儿]", R.mipmap.d_nvhaier);
        map.put("[女孩儿]", R.mipmap.d_nvhaier);
        map.put("[奥特曼]", R.mipmap.d_aoteman);
        map.put("[害羞]", R.mipmap.d_haixiu);
        map.put("[睡觉]", R.mipmap.d_shuijiao);
        map.put("[钱]", R.mipmap.d_qian);
        map.put("[偷笑]", R.mipmap.d_touxiao);
        map.put("[酷]", R.mipmap.d_ku);
        map.put("[衰]", R.mipmap.d_shuai);
        map.put("[吃惊]", R.mipmap.d_chijing);
        map.put("[闭嘴]", R.mipmap.d_bizui);
        map.put("[鄙视]", R.mipmap.d_bishi);
        map.put("[挖鼻屎]", R.mipmap.d_wabishi);
        map.put("[花心]", R.mipmap.d_huaxin);
        map.put("[鼓掌]", R.mipmap.d_guzhang);
        map.put("[悲伤]", R.mipmap.d_beishang);
        map.put("[思考]", R.mipmap.d_sikao);
        map.put("[生病]", R.mipmap.d_shengbing);
        map.put("[亲亲]", R.mipmap.d_qinqin);
        map.put("[怒骂]", R.mipmap.d_numa);
        map.put("[太开心]", R.mipmap.d_taikaixin);
        map.put("[懒得理你]", R.mipmap.d_landelini);
        map.put("[右哼哼]", R.mipmap.d_youhengheng);
        map.put("[带着微博去旅行]", R.mipmap.d_lvxing);
        map.put("[兔子]", R.mipmap.d_tuzi);
        map.put("[熊猫]", R.mipmap.d_xiongmao);
        map.put("[喵喵]", R.mipmap.d_1_miao);
        map.put("[doge]", R.mipmap.d_2_doge);
        map.put("[草泥马]", R.mipmap.d_3_shenshou);
        map.put("[笑cry]", R.mipmap.d_5_xiaoku);
        map.put("[最右]", R.mipmap.d_6_zuiyou);
        map.put("[给力]", R.mipmap.f_geili);
        map.put("[神马]", R.mipmap.f_shenma);
        map.put("[浮云]", R.mipmap.w_fuyun);
        map.put("[威武]", R.mipmap.f_v5);
        map.put("[围观]", R.mipmap.o_weiguan);
        map.put("[呵呵]", R.mipmap.d_hehe);
        map.put("[嘻嘻]", R.mipmap.d_xixi);
        map.put("[哈哈]", R.mipmap.d_haha);
        map.put("[爱你]", R.mipmap.d_aini);
        map.put("[晕]", R.mipmap.d_yun);
        map.put("[泪]", R.mipmap.d_lei);
        map.put("[馋嘴]", R.mipmap.d_chanzui);
        map.put("[哼]", R.mipmap.d_heng);
        map.put("[可爱]", R.mipmap.d_keai);
        map.put("[怒]", R.mipmap.d_nu);
        map.put("[汗]", R.mipmap.d_han);
        map.put("[二哈]",R.mipmap.erha);
        map.put("[污]",R.mipmap.wu);
        map.put("[舔屏]",R.mipmap.tianping);
        map.put("[微笑]",R.mipmap.weixiao);
        map.put("[摊手]",R.mipmap.tanshou);
    }

    /**
     * 根据表情名称获取表情
     * @param name
     * @return
     */
    public static int getImageByName(String name) {
        Integer integer = map.get(name);
        return integer == null ? -1 : integer;
    }
}
