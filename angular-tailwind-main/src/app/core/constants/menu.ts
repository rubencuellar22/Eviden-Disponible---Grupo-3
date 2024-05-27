import { MenuItem } from '../models/menu.model';

export class Menu {
  public static pages: MenuItem[] = [
    {
      //tenia el name de base

      group: '',
      separator: false,
      items: [
    
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'GIN',
          route: '/gift',
        },
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'Nombre',
          route: '/gift',
        },
        
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'Subgrupo',
          route: '/gift',
        },
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'Estátus',
          route: '/gift',
        },
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'Bench',
          route: '/gift',
        },
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'Das',
          route: '/gift',
        },
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'Ciudad',
          route: '/gift',
        },
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'Line_manager',
          route: '/gift',
        },
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'Jornada',
          route: '/gift',
        },
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'GCM',
          route: '/gift',
        },
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'Categoría',
          route: '/gift',
        },
        // NIVELGCM   SCR (+iud)   CC   CCNAME 
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'NivelGCM',
          route: '/gift',
        },  
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'SCR (+iud)',
          route: '/gift',
        },  
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'CC',
          route: '/gift',
        }, 
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'CCName',
          route: '/gift',
        }, 
        {
          icon: 'assets/icons/heroicons/outline/gift.svg',
          label: 'CCName',
          route: '/gift',
        },   
          
        {
          icon: 'assets/icons/heroicons/outline/chart-pie.svg',
          label: 'Nombre',
          route: '/dashboard',
          children: [
            { label: 'Nombre', route: '/dashboard/nfts' },
            // { label: 'Podcast', route: '/dashboard/podcast' },
          ],
        },
        {
          icon: 'assets/icons/heroicons/outline/lock-closed.svg',
          label: 'Auth',
          route: '/auth',
          children: [
            { label: 'Sign up', route: '/auth/sign-up' },
            { label: 'Sign in', route: '/auth/sign-in' },
            { label: 'Forgot Password', route: '/auth/forgot-password' },
            { label: 'New Password', route: '/auth/new-password' },
            { label: 'Two Steps', route: '/auth/two-steps' },
          ],
        },
        {
          icon: 'assets/icons/heroicons/outline/shield-exclamation.svg',
          label: 'Erros',
          route: '/errors',
          children: [
            { label: '404', route: '/errors/404' },
            { label: '500', route: '/errors/500' },
          ],
        },
      ],
    },
    // {
    //         //tenia el name de collaboration

    //   group: '',
    //   separator: true,
    //   items: [
    //     {
    //       icon: 'assets/icons/heroicons/outline/download.svg',
    //       label: 'Download',
    //       route: '/download',
    //     },
    //     {
    //       icon: 'assets/icons/heroicons/outline/gift.svg',
    //       label: 'Gift Card',
    //       route: '/gift',
    //     },
    //     {
    //       icon: 'assets/icons/heroicons/outline/users.svg',
    //       label: 'Users',
    //       route: '/users',
    //     },
    //   ],
    // },
   
  ];
}
