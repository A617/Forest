package edu.nju.data.model;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tj on 2016/5/14.
 */
public class Statistics {
    public static String[] categories = {"api", "django", "gem", "jquery", "web", "irc", "plugin", "database", "android", "git",
            "emacs", "linux", "json", "toolkit", ".net", "os", "xml", "ios", "mvc", "vim", "apache", "maven", "mysql"};
    public static final String[] userCompany = {"Shopify", "Google", "Github", "Twitter", "Microsoft", "Mozilla", "Xamarin", "Heroku",
            "Facebook", "Red Hat"};
    public static String[] countries = {"Afghanistan", "Angola", "Albania", "United Arab Emirates", "Argentina", "Armenia",
            "French Southern and Antarctic Lands", "Australia", "Austria", "Azerbaijan", "Burundi", "Belgium", "Benin", "Burkina Faso",
            "Bangladesh", "Bulgaria", "The Bahamas", "Bosnia and Herzegovina", "Belarus", "Belize", "Bermuda", "Bolivia", "Brazil", "Brunei",
            "Bhutan", "Botswana", "Central African Republic", "Canada", "Switzerland", "Chile", "China", "Ivory Coast", "Cameroon", "Democratic Republic of the Congo",
            "Republic of the Congo", "Colombia", "Costa Rica", "Cuba", "Northern Cyprus", "Cyprus", "Czech Republic", "Djibouti", "Denmark",
            "Dominican Republic", "Algeria", "Ecuador", "Egypt", "Eritrea", "Spain", "Estonia", "Ethiopia", "Finland", "Fiji", "Falkland Islands",
            "Gabon", "Georgia", "Ghana", "Guinea", "Gambia", "Guinea Bissau", "Equatorial Guinea", "Greece", "Greenland",
            "Guatemala", "French Guiana", "Guyana", "Honduras", "Croatia", "Haiti", "Hungary", "Indonesia", "India", "Ireland", "Iran", "Iraq", "Iceland",
            "Israel", "Italy", "Jamaica", "Jordan", "Japan", "Kazakhstan", "Kenya", "Kyrgyzstan", "Cambodia", "South Korea", "Kosovo", "Kuwait",
            "Laos", "Lebanon", "Liberia", "Libya", "Sri Lanka", "Lesotho", "Lithuania", "Luxembourg", "Latvia", "Morocco", "Moldova", "Madagascar",
            "Mexico", "Macedonia", "Mali", "Myanmar", "Montenegro", "Mongolia", "Mozambique", "Mauritania", "Malawi", "Malaysia", "Namibia",
            "New Caledonia", "Niger", "Nigeria", "Nicaragua", "Netherlands", "Norway", "Nepal", "New Zealand", "Oman", "Pakistan", "Panama",
            "Peru", "Philippines", "Papua New Guinea", "Poland", "Puerto Rico", "North Korea", "Portugal", "Paraguay", "Qatar", "Romania", "Russia",
            "Rwanda", "Western Sahara", "Saudi Arabia", "Sudan", "South Sudan", "Senegal", "Solomon Islands", "Sierra Leone", "El Salvador", "Somaliland",
            "Somalia", "Republic of Serbia", "Suriname", "Slovakia", "Slovenia", "Sweden", "Swaziland", "Syria", "Chad", "Togo", "Thailand", "Tajikistan",
            "Turkmenistan", "East Timor", "Trinidad and Tobago", "Tunisia", "Turkey", "United Republic of Tanzania", "Uganda", "Ukraine", "Uruguay",
            "Uzbekistan", "Venezuela", "Vietnam", "Vanuatu", "West Bank", "Yemen", "South Africa", "Zambia", "Zimbabwe", "United Kingdom", "United States of America", "France", "Germany"
    };
    public static String[] big = {"United Kingdom", "United States of America", "France", "Germany"};
    public static String[][] bigCountryCity = {{"london", "uk", "england"}, {"san francisco", "new york", "seattle", "us", "america"}, {"paris"}, {"berlin"}};
    //germany:berlin,france:paris,uk:london
    public static String[] year = {"2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016"};
    public static List<String> tag = Arrays.asList(categories);
    public static List<String> country = Arrays.asList(countries);
    public static List<String> bigCountries = Arrays.asList(big);
    public static String[] search = {"stars:<", "stars:>", "forks:<", "forks:>", "contributors:<", "contributors:>"};
    public static List<String> searchPerform = Arrays.asList(search);

    public static int getPerformIndex(String str) {
        return searchPerform.lastIndexOf(str);
    }

    public static String[] province = {"黑龙江", "吉林", "辽宁", "河北", "山东", "江苏", "浙江", "安徽", "河南", "山西", "陕西", "甘肃",
            "湖北", "江西", "福建", "湖南", "贵州", "四川", "云南", "青海", "海南", "上海", "重庆", "天津", "北京", "宁夏", "内蒙古", "广西", "新疆", "西藏",
            "广东", "香港", "台湾", "澳门"};
    public static String[] province1 = {"黑龙江省", "吉林省", "辽宁省", "河北省", "山东省", "江苏省", "浙江省", "安徽省", "河南省", "山西省", "陕西省", "甘肃省",
            "湖北省", "江西省", "福建省", "湖南省", "贵州省", "四川省", "云南省", "青海省", "海南省", "上海", "重庆", "天津", "北京", "宁夏", "内蒙古", "广西", "新疆", "西藏",
            "广东省", "香港市", "台湾省", "澳门"};
    public static List<String> provinces = Arrays.asList(province);
    public static String[] englishProvince = {"heilongjiang", "jilin", "liaoning", "hebei", "shandong", "jiangsu", "zhejiang", "anhui", "henan",
            "shanxin", "shaanxi", "gansu", "hubei", "jiangxi", "fujian", "hunan", "guizhou", "sichuan", "yunnan", "qinghai",
            "hainan", "shanghai", "chongqing", "tianjin", "beijing", "ningxia", "neimenggu", "guangxi", "xinjiang", "xizang",
            "guangdong", "xianggang", "taiwan", "aomen"};
    public static String[][] provinceCity = {{"harbin", "haerbin"},
            {"changchun"},
            {"da,lian", "chaoyang", "shenyang"},
            {"qinhuangdao", "baoding", "tangshan"},
            {"zaozhuang", "qingdao", "yantai", "jinan", "linyi"},
            {"nanking", "zhenjiang", "wuxi", "lianyungang", "suzhou", "kunshan", "nanjing"},
            {"wenzhou", "yiwu", "west,lake", "ningbo", "hangchow", "hangzhou", "xiaoshan"},
            {"maanshan", "hefei"},
            {"zhengzhou"},
            {"taiyuan"},
            {"xi'an","yangling","xian"},
            {"lanzhou"},
            {"wuhan","guizhou"},
            {"nanchang"},
            {"xiamen","quanzhou","nanping","fuzhou"},
            {"changsha","yueyang"},
            {"guiyang"},
            {"chengdu"},
            {"dali","kunming"},
            {"xining"},
            {"haikou","sanya"},
            {"shanghai"},
            {"chongqing"},
            {"tianjin"},
            {"peking"},
            {"ningxia"},
            {"neimenggu"},
            {"guangxi"},
            {"xinjiang"},
            {"xizang"},
            {"guangzhou","shenzhen","dongguan","shantou","zhuhai","foshan","huizhou"},
            {"xianggang","Hongkong","Hong Kong"},
            {"taiwan","taibei"},
            {"aomen"}};
    public static String[] famousCity={"南京","杭州","深圳","珠海","广州","济南","苏州","合肥","武汉","无锡","连云港","镇江"};
    public static String[] EnglishCity={"nanjing","hangzhou","shenzhen","zhuhai","guangzhou","jinan","suzhou","hefei","wuhan","wuxi","lianyungang","zhenjiang"};
}
