import i18n from 'i18next';
import {initReactI18next} from "react-i18next";

i18n.use(initReactI18next).init({
    resources: {
        en: {
            translations: {
                'Sign Up': 'Sign Up',
                'Display Name': 'Display Name',
                'Password': 'Password',
                'Password Repeat': 'Password Repeat',
                'Username':'Username'

            }
        }, tr: {
            translations: {
                'Sign Up': 'Kayıt Ol',
                'Display Name': 'Görünen İsim',
                'Password': 'Şifre',
                'Password Repeat': 'Şifre Tekrarı',
                'Username':'Kullanıcı Adı'
            }
        }
    }, fallbackLng: 'tr', ns: ['translations'], defaultNS: 'translations', interpolation: {
        escapeValue: false, formatSeparator: ','
    }, react: {
        wait: true
    }

});

export default i18n;