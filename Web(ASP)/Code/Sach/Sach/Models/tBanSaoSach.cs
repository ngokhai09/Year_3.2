//------------------------------------------------------------------------------
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
    
    public partial class tBanSaoSach
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public tBanSaoSach()
        {
            this.tMuonTras = new HashSet<tMuonTra>();
        }
    
        public string MaBanSao { get; set; }
        public string MaSach { get; set; }
        public Nullable<bool> TrangThai { get; set; }
        public string TinhTrangSach { get; set; }
        public string ViTri { get; set; }
    
        public virtual tSach tSach { get; set; }
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<tMuonTra> tMuonTras { get; set; }
    }
}
