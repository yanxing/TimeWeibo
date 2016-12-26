package com.yanxing.weibo.util;

import android.support.v4.util.ArrayMap;

import com.yanxing.weibo.R;

/**
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
        map.put("[泪流满面]", R.mipmap.lxh_leiliumanmian);

                [巨汗]=lxh_juhan.png
                [抠鼻屎]=lxh_koubishi.png
                [求关注]=lxh_qiuguanzhu.png
                [好喜欢]=lxh_haoxihuan.png
                [崩溃]=lxh_bengkui.png
                [好囧]=lxh_haojiong.png
                [震惊]=lxh_zhenjing.png
                [别烦我]=lxh_biefanwo.png
                [不好意思]=lxh_buhaoyisi.png
                [羞嗒嗒]=lxh_xiudada.png
                [得意地笑]=lxh_deyidexiao.png
                [纠结]=lxh_jiujie.png
                [给劲]=lxh_feijin.png
                [悲催]=lxh_beicui.png
                [甩甩手]= lxh_shuaishuaishou.png
                [好棒]=lxh_haobang.png
                [瞧瞧]=lxh_qiaoqiao.png
                [不想上班]=lxh_buxiangshangban.png
                [困死了]=lxh_kunsile.png
                [许愿]=lxh_xuyuan.png
                [丘比特]=lxh_qiubite.png
                [有鸭梨]=lxh_youyali.png
                [想一想]=lxh_xiangyixiang.png
                [躁狂症]=lxh_kuangzaozheng.png
                [转发]=lxh_zhuanfa.png
                [互相膜拜]=lxh_xianghumobai.png
                [雷锋]=lxh_leifeng.png
                [杰克逊]=lxh_jiekexun.png
                [玫瑰]=lxh_meigui.png
                [hold住]=lxh_holdzhu.png
                [群体围观]=lxh_quntiweiguan.png
                [推荐]=lxh_tuijian.png
                [赞啊]=lxh_zana.png
                [被电]=lxh_beidian.png
                [霹雳]=lxh_pili.png
                [蜡烛]=o_lazhu.png
                [发红包]=o_fahongbao.png
                [汽车]=o_qiche.png
                [飞机]=o_feiji.png
                [自行车]=o_zixingche.png
                [礼物]=o_liwu.png
                [照相机]=o_zhaoxiangji.png
                [手机]=o_shouji.png
                [风扇]=o_fengshan.png
                [话筒]=o_huatong.png
                [钟]=o_zhong.png
                [足球]=o_zuqiu.png
                [电影]=o_dianying.png
                [音乐]=o_yinyue.png
                [实习]=o_shixi.png
                [鲜花]=w_xianhua.png
                [心]=l_xin.png
                [伤心]=l_shangxin.png
                [爱心传递]=l_aixinchuandi.png
                [互粉]=f_hufen.png
                [萌]=f_meng.png
                [囧]=f_jiong.png
                [织]=f_zhi.png
                [帅]=f_shuai.png
                [喜]=f_xi.png
                [围脖]=o_weibo.png
                [温暖帽子]=o_wennuanmaozi.png
                [手套]=o_shoutao.png
                [绿丝带]=o_lvsidai.png
                [红丝带]=o_hongsidai.png
                [蛋糕]=o_dangao.png
                [咖啡]=o_kafei.png
                [西瓜]=o_xigua.png
                [冰棍]=o_bingun.png
                [干杯]=o_ganbei.png
                [猪头]=d_zhutou.png
                [握手]=h_woshou.png
                [耶]=h_ye.png
                [good]=h_good.png
                [弱]=h_ruo.png
                [不要]=h_buyao.png
                [ok]=h_ok.png
                [赞]=h_zan.png
                [来]=h_lai.png
                [haha]=h_haha.png
                [拳头]=h_quantou.png
                [最差]=h_zuicha.png
                [月亮]=w_yueliang.png
                [太阳]=w_taiyang.png
                [微风]=w_weifeng.png
                [沙尘暴]=w_shachenbao.png
                [下雨]=w_xiayu.png
                [雪]=w_xue.png
                [雪人]=w_xueren.png
                [落叶]=w_luoye.png
                [左哼哼]=d_zuohengheng.png
                [嘘]=d_xu.png
                [委屈]=d_weiqu.png
                [吐]=d_tu.png
                [可怜]=d_kelian.png
                [打哈气]=d_dahaqi.png
                [做鬼脸]=d_zuoguilian.png
                [失望]=d_shiwang.png
                [顶]=d_ding.png
                [疑问]=d_yiwen.png
                [书呆子]=d_shudaizi.png
                [困]=d_kun.png
                [感冒]=d_ganmao.png
                [拜拜]=d_baibai.png
                [黑线]=d_heixian.png
                [阴险]=d_yinxian.png
                [愤怒]=d_fennu.png
                [男孩儿]=d_nanhaier.png
                [女孩儿]=d_nvhaier.png
                [奥特曼]=d_aoteman.png
                [害羞]=d_haixiu.png
                [睡觉]=d_shuijiao.png
                [钱]=d_qian.png
                [偷笑]=d_touxiao.png
                [酷]=d_ku.png
                [衰]=d_shuai.png
                [吃惊]=d_chijing.png
                [闭嘴]=d_bizui.png
                [鄙视]=d_bishi.png
                [挖鼻屎]=d_wabishi.png
                [花心]=d_huaxin.png
                [鼓掌]=d_guzhang.png
                [悲伤]=d_beishang.png
                [思考]=d_sikao.png
                [生病]=d_shengbing.png
                [亲亲]=d_qinqin.png
                [怒骂]=d_numa.png
                [太开心]=d_taikaixin.png
                [懒得理你]=d_landelini.png
                [右哼哼]=d_youhengheng.png
                [带着微博去旅行]=d_lvxing.png
                [兔子]=d_tuzi.png
                [熊猫]=d_xiongmao.png
                [喵喵]=d_1_miao.png
                [doge]=d_2_doge.png
                [草泥马]=d_3_shenshou.png
                [笑cry]=d_5_xiaoku.png
                [最右]=d_6_zuiyou.png
                [给力]=f_geili.png
                [神马]=f_shenma.png
                [浮云]=w_fuyun.png
                [威武]=f_v5.png
                [围观]=o_weiguan.png
                [呵呵]=d_hehe.png
                [嘻嘻]=d_xixi.png
                [哈哈]=d_haha.png
                [爱你]=d_aini.png
                [晕]=d_yun.png
                [泪]=d_lei.png
                [馋嘴]=d_chanzui.png
                [哼]=d_heng.png
                [可爱]=d_keai.png
                [怒]=d_nu.png
                [汗]=d_han.png
    }

    public static int getImageByName(String name) {
        Integer integer = sMap.get(name);
        return integer == null ? -1 : integer;
    }
}
