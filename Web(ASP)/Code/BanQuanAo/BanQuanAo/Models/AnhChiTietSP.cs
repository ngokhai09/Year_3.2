//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace BanQuanAo.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class AnhChiTietSP
    {
        public string MaAnh { get; set; }
        public string MaSPTheoMau { get; set; }
        public string TenFileAnh { get; set; }
    
        public virtual SPtheoMau SPtheoMau { get; set; }
    }
}
