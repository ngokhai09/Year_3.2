﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Sach.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;

    public partial class tSach
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public tSach()
        {
            this.tBanSaoSaches = new HashSet<tBanSaoSach>();
        }
    
        public string MaSach { get; set; }
        public string TenSach { get; set; }
        public string MaLoai { get; set; }
        public string MaNgonNgu { get; set; }
        public string MaNXB { get; set; }
        public string TacGia { get; set; }
        [RegularExpression(@"[0-9]+", ErrorMessage = "Năm xuất bản phải là số")]
        public string NamXB { get; set; }
        public string LanXB { get; set; }
        public string TomTat { get; set; }
        public string TongSoTrang { get; set; }
        public string Tap { get; set; }
        public string TongSoTap { get; set; }
        public Nullable<double> GiaTriSach { get; set; }
        public string FileAnh { get; set; }
        public string MaTheLoai { get; set; }
        public string GioiThieu { get; set; }
    
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<tBanSaoSach> tBanSaoSaches { get; set; }
        public virtual tLoaiSach tLoaiSach { get; set; }
        public virtual tNgonNgu tNgonNgu { get; set; }
        public virtual tNhaXB tNhaXB { get; set; }
    }
}